package com.jobs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobs.model.Competence;
import com.jobs.repository.CompetenceRepository;

@Service
public class CompetenceService {

	@Autowired
	private CompetenceRepository repository;
	
	public Competence create(Competence competence) {
		return repository.save(competence);
	}
	
	public Optional<Competence> read(int id){
		return repository.findById(id);
	}
	
	public Iterable<Competence> readAll(){
		return repository.findAll();
	}
	
	public Competence update(Competence competence) {
		return repository.save(competence);
	}
	
	public void delete(int id) {
		repository.deleteById(id);
	}
	
	public void delete(Competence competence) {
		repository.delete(competence);
	}
}
