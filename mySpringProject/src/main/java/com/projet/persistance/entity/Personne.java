package com.projet.persistance.entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entité représentant la table personne sous forme de classe.
 */

@Entity

public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_personne", columnDefinition = "serial")
    private Long id;

    @NotNull
    private String nom;

    @NotNull
    private String prenom;

    @NotNull
    private int age;

    @Nullable()
    @OneToOne
    private NiveauEtude niveauEtude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom.toUpperCase();
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        prenom = prenom.toLowerCase();
        return prenom.replace(prenom.charAt(0),Character.toUpperCase(prenom.charAt(0)));
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public NiveauEtude getNiveauEtude() {
        return niveauEtude;
    }

    public void setNiveauEtude(NiveauEtude niveauEtude) {
        this.niveauEtude = niveauEtude;
    }
}
