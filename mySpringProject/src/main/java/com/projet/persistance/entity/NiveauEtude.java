package com.projet.persistance.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="niveau_etude")
public class NiveauEtude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_niveau", columnDefinition = "serial")
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
        libelle = libelle.toLowerCase();
        return libelle.replace(libelle.charAt(0), Character.toUpperCase(libelle.charAt(0)));
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
