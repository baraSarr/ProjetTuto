package com.jobs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jobs.model.Offre;
import com.jobs.model.Utilisateur;

@Repository
public interface OffreRepository extends CrudRepository<Offre, Integer>{
	
	public Iterable<Offre> findByRecruteur(Utilisateur user);
	
	public Iterable<Offre> findByPostulantsIn(List<Utilisateur> users);

}
