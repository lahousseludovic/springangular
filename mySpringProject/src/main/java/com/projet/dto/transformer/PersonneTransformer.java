package com.projet.dto.transformer;

import com.projet.dto.NiveauEtudeDTO;
import com.projet.dto.PersonneDTO;
import com.projet.persistance.entity.NiveauEtude;
import com.projet.persistance.entity.Personne;
import com.projet.persistance.repository.NiveauEtudeRepository;
import com.projet.persistance.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersonneTransformer {

    @Autowired
    NiveauEtudeRepository niveauEtudeRepository;

    public static Collection<PersonneDTO> entityToDto(Collection<Personne> personneCollection){

        if(personneCollection == null)
            return null;

        List<PersonneDTO> personneDTOList = new ArrayList<>();
        for(Personne personne: personneCollection){
            personneDTOList.add(entityToDto(personne));
        }
        return personneDTOList;
    }

    public static PersonneDTO entityToDto(Personne personne){
        if(personne == null)
            return null;

        PersonneDTO personneDTO = new PersonneDTO();
        personneDTO.setId(personne.getId());
        personneDTO.setNom(personne.getNom());
        personneDTO.setPrenom(personne.getPrenom());
        personneDTO.setAge(personne.getAge());

        if(personne.getNiveauEtude() != null) {
            NiveauEtudeDTO niveauEtudeDTO = NiveauEtudeTransformer.entityToDto(personne.getNiveauEtude());
            personneDTO.setNiveau_etude(niveauEtudeDTO);
        }

        return personneDTO;
    }

    public static Collection<Personne> dtoToEntity(Collection<PersonneDTO> personneCollectionDTO){

        if(personneCollectionDTO == null)
            return null;

        List<Personne> personneList = new ArrayList<>();
        for(PersonneDTO personneDTO: personneCollectionDTO){
            personneList.add(dtoToEntity(personneDTO));
        }
        return personneList;
    }

    public static Personne dtoToEntity(PersonneDTO personneDTO){
        if(personneDTO == null)
            return null;

        Personne personne = new Personne();
        personne.setNom(personneDTO.getNom());
        personne.setPrenom(personneDTO.getPrenom());
        personne.setAge(personneDTO.getAge());

        return personne;
    }
}
