package com.projet.business;

import com.projet.dto.NiveauEtudeDTO;
import com.projet.dto.PersonneDTO;
import com.projet.dto.transformer.NiveauEtudeTransformer;
import com.projet.dto.transformer.PersonneTransformer;
import com.projet.persistance.entity.NiveauEtude;
import com.projet.persistance.entity.Personne;
import com.projet.persistance.repository.NiveauEtudeRepository;
import com.projet.persistance.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PersonneBusiness {

    @Autowired
    PersonneRepository personneRepository;

    @Autowired
    NiveauEtudeRepository niveauEtudeRepository;

    public List<PersonneDTO> getAll() {

        return new ArrayList<>(PersonneTransformer.entityToDto(personneRepository.findAll()));
    }

    public void deleteById(Long id) {

        personneRepository.deleteById(id);
    }

    public PersonneDTO findById(Long id) {

        return PersonneTransformer.entityToDto(personneRepository.findById(id).get());
    }

    public PersonneDTO update(PersonneDTO personneDTO) {

        Personne personne = personneRepository.findById(personneDTO.getId()).get();
        personne.setNom(personneDTO.getNom());
        personne.setPrenom(personneDTO.getPrenom());
        personne.setAge(personneDTO.getAge());
        personne.setNiveauEtude(searchNiveauEtude(personneDTO));
        return PersonneTransformer.entityToDto(personneRepository.save(personne));
    }

    public PersonneDTO add(PersonneDTO personneDTO) {
        Personne personne = PersonneTransformer.dtoToEntity(personneDTO);
        personne.setNiveauEtude(searchNiveauEtude(personneDTO));
        return PersonneTransformer.entityToDto(personneRepository.save(personne));
    }

    public Collection<PersonneDTO> findByNiveauEtude(String niveauEtude) {
        return PersonneTransformer.entityToDto(personneRepository.findByNiveauEtude_Libelle(niveauEtude));
    }

    private NiveauEtude searchNiveauEtude(PersonneDTO personneDTO) {

        if(personneDTO.getNiveau_etude() == null)
            return niveauEtudeRepository.findByLibelle("Aucun");

        NiveauEtude niveauEtude = niveauEtudeRepository.findByLibelle(personneDTO.getNiveau_etude().getLibelle());
        if (niveauEtude != null) {
            return niveauEtude;
        }

        if (personneDTO.getNiveau_etude().getLibelle().trim() != "") {
            NiveauEtudeDTO niveauEtudeDTO = new NiveauEtudeDTO(personneDTO.getNiveau_etude().getLibelle());
            return niveauEtudeRepository.save(NiveauEtudeTransformer.dtoToEntity(niveauEtudeDTO));
        }

        niveauEtude = niveauEtudeRepository.findByLibelle("Aucun");
        return niveauEtudeRepository.save(niveauEtude);

    }
}
