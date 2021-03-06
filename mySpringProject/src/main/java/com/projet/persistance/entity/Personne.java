package com.projet.persistance.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entité représentant la table personne sous forme de classe.
 */

@Entity
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @NotNull
    private String nom;

    @NotNull
    private String prenom;

    @NotNull
    private int age;

    //Plusieurs personnes peuvent avoir le même niveau d'étude
    @ManyToOne
    @JoinColumn(name="id_niveau", referencedColumnName = "id")
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
        nom = nom.toLowerCase();
        this.nom = nom.replaceFirst((nom.charAt(0)+""), (nom.charAt(0)+"").toUpperCase());
    }

    public String getPrenom() {
        prenom = prenom.toLowerCase();
        return prenom.replaceFirst(prenom.charAt(0)+"",(prenom.charAt(0)+"").toUpperCase());
    }

    public void setPrenom(String prenom) {
        prenom = prenom.toLowerCase();
        this.prenom = prenom.replaceFirst((prenom.charAt(0)+""), (prenom.charAt(0)+"").toUpperCase());
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
