package com.jobs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jobs.model.Experience;
import com.jobs.model.Utilisateur;

@Repository
public interface ExperienceRepository extends CrudRepository<Experience, Integer>{

	public Iterable<Experience> findByUtilisateur(Utilisateur user);
}
