package com.projet.business;

import com.projet.dto.NiveauEtudeDTO;
import com.projet.dto.transformer.NiveauEtudeTransformer;
import com.projet.persistance.repository.NiveauEtudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NiveauEtudeBusiness {

    @Autowired
    NiveauEtudeRepository niveauEtudeRepository;

    public List<NiveauEtudeDTO> getAll() {
        return new ArrayList<>(NiveauEtudeTransformer.entityToDto(niveauEtudeRepository.findAll()));
    }
}
