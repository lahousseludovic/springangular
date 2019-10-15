package com.projet.dto.transformer;

import com.projet.dto.NiveauEtudeDTO;
import com.projet.persistance.entity.NiveauEtude;

public class NiveauEtudeTransformer {

    public static NiveauEtudeDTO entityToDto(NiveauEtude niveauEtude) {
        if (niveauEtude == null)
            return null;

        NiveauEtudeDTO niveauEtudeDTO = new NiveauEtudeDTO();
        niveauEtudeDTO.setLibelle(niveauEtude.getLibelle());
        niveauEtudeDTO.setId(niveauEtude.getId());

        return niveauEtudeDTO;
    }

    public static NiveauEtude dtoToEntity(NiveauEtudeDTO niveauEtudeDTO) {
        if (niveauEtudeDTO == null)
            return null;

        NiveauEtude niveauEtude = new NiveauEtude();
        niveauEtude.setLibelle(niveauEtudeDTO.getLibelle());

        return niveauEtude;
    }
}
