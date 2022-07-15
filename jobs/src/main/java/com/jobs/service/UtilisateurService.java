package com.jobs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobs.model.Utilisateur;
import com.jobs.repository.UtilisateurRepository;

@Service
public class UtilisateurService {

	@Autowired
	private UtilisateurRepository repository;
	
	public Utilisateur create(Utilisateur user) {
		return repository.save(user);
	}
	
	public Utilisateur update(Utilisateur user) {
		return repository.save(user);
	}
	
	public Optional<Utilisateur> read(int id) {
		return repository.findById(id);
	}
	
	public Iterable<Utilisateur> readAll() {
		return repository.findAll();
	}
	
	public void delete(int id) {
		repository.deleteById(id);
	}
	
	public void delete(Utilisateur user) {
		repository.delete(user);
	}
	
	public Optional<Utilisateur> findAccount(String login){
		return repository.findByLogin(login);
	}
	
	public Optional<Utilisateur> authentifier(String login, String password) {
		Optional<Utilisateur> invite = repository.findByLoginAndPassword(login,password);
		return invite;
	}
}
