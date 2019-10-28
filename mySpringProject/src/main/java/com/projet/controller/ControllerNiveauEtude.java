package com.projet.controller;

import com.projet.business.NiveauEtudeBusiness;
import com.projet.business.PersonneBusiness;
import com.projet.dto.NiveauEtudeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("monAppli/niveauEtude")
@CrossOrigin
public class ControllerNiveauEtude {

    @Autowired
    private NiveauEtudeBusiness niveauEtudeBusiness;

    @GetMapping("")
    public List<NiveauEtudeDTO> getAll() {
        return niveauEtudeBusiness.getAll();
    }
}

