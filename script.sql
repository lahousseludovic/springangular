drop rule rule_delete on niveau_etude;
drop table if exists personne cascade;
drop table if exists niveau_etude cascade;

CREATE TABLE niveau_etude (
    id SERIAL,
    libelle TEXT NOT NULL,
    CONSTRAINT pk_niveau_etude PRIMARY KEY(id)
);

CREATE TABLE personne (
    id SERIAL,
    nom TEXT NOT NULL,
    prenom TEXT NOT NULL,
    age int NOT NULL,
    id_niveau Integer,
    CONSTRAINT pk_personne PRIMARY KEY(id),
    CONSTRAINT fk_niveau_etude FOREIGN KEY(id_niveau) REFERENCES niveau_etude(id) on delete set null
);

INSERT INTO niveau_etude(libelle) VALUES ('Master');
INSERT INTO niveau_etude(libelle) VALUES ('Licence Pro');
INSERT INTO niveau_etude(libelle) VALUES ('Dut');
INSERT INTO niveau_etude(libelle) VALUES ('Bts');
INSERT INTO niveau_etude(libelle) VALUES ('Autre');
INSERT INTO niveau_etude(libelle) VALUES ('Aucun');

INSERT INTO personne(prenom, nom, age, id_niveau) VALUES ('Ludovic','Lahousse', 31,2);
INSERT INTO personne(prenom, nom, age, id_niveau) VALUES ('Antoine','Jouve', 24,1);
INSERT INTO personne(prenom, nom, age, id_niveau) VALUES ('Abbas','Attaf', 25,2);
INSERT INTO personne(prenom, nom, age, id_niveau) VALUES ('Arthur','Brandao', 23,5);
INSERT INTO personne(prenom, nom, age, id_niveau) VALUES ('Pierre','Delgrange', 32,2);
INSERT INTO personne(prenom, nom, age, id_niveau) VALUES ('Nagi','Karaouzene',26,2);

CREATE RULE rule_delete as on delete to niveau_etude do also update personne set id_niveau=(select id from niveau_etude where libelle='Aucun') where id_niveau = OlD.id;