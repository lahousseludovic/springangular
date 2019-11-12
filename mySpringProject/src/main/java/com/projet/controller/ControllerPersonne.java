package com.projet.controller;

import com.projet.business.PersonneBusiness;
import com.projet.dto.PersonneDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/monAppli/personne")
@CrossOrigin
public class ControllerPersonne {

    @Autowired
    private PersonneBusiness personneBusiness;

    @GetMapping("")
    public List<PersonneDTO> getAll() {
        return personneBusiness.getAll();
    }

    @GetMapping("/{id}")
    public PersonneDTO getById(@PathVariable("id") @NotNull Long id) {
        return personneBusiness.findById(id);
    }

    @GetMapping("/etude/{niveau_etude}")
    public Collection<PersonneDTO> getByNiveauEtude(@PathVariable("niveau_etude") @NotNull String niveau_etude) {
        return personneBusiness.findByNiveauEtude(niveau_etude);
    }


    @PutMapping("/update")
    public PersonneDTO update(@RequestBody PersonneDTO personneDTO) {

        return personneBusiness.update(personneDTO);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteById(@NotNull @PathVariable("id") Long id) {

        personneBusiness.deleteById(id);
    }

    @PostMapping("/add")
    public PersonneDTO add(@RequestBody PersonneDTO personneDTO) {

        return personneBusiness.add(personneDTO);
    }
}
