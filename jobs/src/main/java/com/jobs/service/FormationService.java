package com.jobs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobs.model.Formation;
import com.jobs.model.Utilisateur;
import com.jobs.repository.FormationRepository;

@Service
public class FormationService {
	
	@Autowired
	private FormationRepository repository;

	public Formation create(Formation formation) {
		return repository.save(formation);
	}
	
	public Optional<Formation> read(int id){
		return repository.findById(id);
	}
	
	public Iterable<Formation> readAll(){
		return repository.findAll();
	}
	
	public Formation update(Formation formation) {
		return repository.save(formation);
	}
	
	public void delete(int id) {
		repository.deleteById(id);
	}
	
	public void delete(Formation formation) {
		repository.delete(formation);
	}
	
	public Iterable<Formation> findByUser(Utilisateur user){
		return repository.findByUtilisateur(user);
	}
}
