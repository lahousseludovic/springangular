package com.projet.persistance.repository;

import com.projet.persistance.entity.NiveauEtude;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface permettant de communiquer avec la base de données pour la table niveau_etude.
 */
@Repository
public interface NiveauEtudeRepository extends CrudRepository<NiveauEtude, Long> {


}
