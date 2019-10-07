package com.projet.controller;

import com.projet.business.PersonneBusiness;
import com.projet.business.dto.PersonneDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/monAppli/personne")
@CrossOrigin
public class ControllerPersonne {

    @Autowired
    private PersonneBusiness personneBusiness;

    @GetMapping("")
    public List<PersonneDTO> getAll(){
       List<PersonneDTO> personneDTOList = personneBusiness.getAll();
        return personneDTOList;
    }

    @GetMapping("/{id}")
    public PersonneDTO getById(@PathVariable("id") @NotNull Long id ){
        PersonneDTO personneDTO = personneBusiness.findById(id);
        return personneDTO;
    }

    @PutMapping("/update")
    public PersonneDTO update(@RequestBody PersonneDTO personneDTO){
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
