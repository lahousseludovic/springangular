package com.projet.dto.transformer;

import com.projet.dto.NiveauEtudeDTO;
import com.projet.persistance.entity.NiveauEtude;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NiveauEtudeTransformer {


    public static List<NiveauEtudeDTO> entityToDto(Collection<NiveauEtude> niveauEtudes){
       List<NiveauEtudeDTO> niveauEtudeDTOList = new ArrayList<>();
        for (NiveauEtude niveauEtude: niveauEtudes) {
            niveauEtudeDTOList.add(entityToDto(niveauEtude));
        }
        return niveauEtudeDTOList;
    }

    public static NiveauEtudeDTO entityToDto(NiveauEtude niveauEtude) {
        if (niveauEtude == null)
            return null;

        NiveauEtudeDTO niveauEtudeDTO = new NiveauEtudeDTO();
        niveauEtudeDTO.setLibelle(niveauEtude.getLibelle());
        niveauEtudeDTO.setId(niveauEtude.getId());

        return niveauEtudeDTO;
    }

    public static List<NiveauEtude> dtoToEntity(Collection<NiveauEtudeDTO> niveauEtudeDTOS){
        List<NiveauEtude> niveauEtudeList = new ArrayList<>();
        for(NiveauEtudeDTO niveauEtudeDTO: niveauEtudeDTOS){
            niveauEtudeList.add(dtoToEntity(niveauEtudeDTO));
        }
        return niveauEtudeList;
    }

    public static NiveauEtude dtoToEntity(NiveauEtudeDTO niveauEtudeDTO) {
        if (niveauEtudeDTO == null)
            return null;

        NiveauEtude niveauEtude = new NiveauEtude();
        niveauEtude.setLibelle(niveauEtudeDTO.getLibelle());

        return niveauEtude;
    }
}
