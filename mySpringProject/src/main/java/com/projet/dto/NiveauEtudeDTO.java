package com.projet.dto;

public class NiveauEtudeDTO {

    private long id;

    private String libelle;

    public NiveauEtudeDTO(String libelle){
        this.libelle = libelle;
    }

    public NiveauEtudeDTO(){

    }

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
