package com.jobs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jobs.model.Formation;
import com.jobs.model.Utilisateur;

@Repository
public interface FormationRepository extends CrudRepository<Formation, Integer>{
	
	public Iterable<Formation> findByUtilisateur(Utilisateur user);
}
