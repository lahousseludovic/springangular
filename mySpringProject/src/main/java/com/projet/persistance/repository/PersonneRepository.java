package com.projet.persistance.repository;

import com.projet.persistance.entity.Personne;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Interface permettant de communiquer avec la base de données pour la table personne.
 */
@Repository
@Transactional
public interface PersonneRepository extends CrudRepository<Personne,Long>{

    // Déclaré mais pas obligé car existente dans le CRUD
    Collection<Personne> findAll();
}
