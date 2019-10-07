package com.projet.business;

import com.projet.business.dto.PersonneDTO;
import com.projet.business.dto.transformer.PersonneTransformer;
import com.projet.persistance.entity.Personne;
import com.projet.persistance.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonneBusiness {

    @Autowired
    PersonneRepository personneRepository;


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
        return PersonneTransformer.entityToDto(personneRepository.save(personne));
    }

    public PersonneDTO add(PersonneDTO personneDTO) {
        Personne personne = PersonneTransformer.dtoToEntity(personneDTO);
        return PersonneTransformer.entityToDto(personneRepository.save(personne));
    }
}
