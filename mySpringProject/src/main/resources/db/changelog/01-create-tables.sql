--liquibase formatted sql

CREATE TABLE personne (
    id_personne SERIAL,
    nom TEXT NOT NULL,
    prenom TEXT NOT NULL,
    age int NOT NULL,
    PRIMARY KEY(id_personne)
);