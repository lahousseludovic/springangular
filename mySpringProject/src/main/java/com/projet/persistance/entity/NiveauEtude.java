package com.projet.persistance.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity

public class NiveauEtude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private long id;

    @NotNull
    private String libelle;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
