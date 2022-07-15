package com.jobs.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jobs.model.Utilisateur;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer>{

	public Optional<Utilisateur> findByLoginAndPassword(String login, String password);
	
	public Optional<Utilisateur> findByLogin(String login);
}
