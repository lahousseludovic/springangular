package com.projet.dto;

public class PersonneDTO {

    private Long id;

    private String nom;

    private String prenom;

    private int age;

    private NiveauEtudeDTO niveau_etude;

    public PersonneDTO(String nom, String prenom, int age){
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public PersonneDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public NiveauEtudeDTO getNiveau_etude() {
        return niveau_etude;
    }

    public void setNiveau_etude(NiveauEtudeDTO niveau_etude) {
        this.niveau_etude = niveau_etude;
    }
}
