package com.projet.business.dto.transformer;

import com.projet.business.dto.PersonneDTO;
import com.projet.persistance.entity.Personne;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.GsonBuilderUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersonneTransformer {

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
//        if (personneDTO.getId() == null) {
//            personne.setId(0L);
//        } else {
//            personne.setId(personneDTO.getId());
//        }
        personne.setNom(personneDTO.getNom());
        personne.setPrenom(personneDTO.getPrenom());
        personne.setAge(personneDTO.getAge());

        return personne;
    }
}
