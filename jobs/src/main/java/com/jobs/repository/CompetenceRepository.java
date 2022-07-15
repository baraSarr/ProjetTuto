package com.jobs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jobs.model.Competence;
import com.jobs.model.Formation;
import com.jobs.model.Offre;
import com.jobs.model.Utilisateur;

@Repository
public interface CompetenceRepository extends CrudRepository<Competence, Integer>{

	public Iterable<Competence> findByUtilisateursIn(List<Utilisateur> users);
	
	public Iterable<Competence> findByOffresIn(List<Offre> offres);
}
