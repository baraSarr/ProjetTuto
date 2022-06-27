package com.jobs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobs.model.Societe;
import com.jobs.repository.SocieteRepository;

@Service
public class SocieteService {

	@Autowired
	private SocieteRepository repository;
	
	public Societe create(Societe societe) {
		return repository.save(societe);
	}
	
	public Optional<Societe> read(int id){
		return repository.findById(id);
	}
	
	public Iterable<Societe> readAll(){
		return repository.findAll();
	}
	
	public Societe update(Societe societe) {
		return repository.save(societe);
	}
	
	public void delete(int id) {
		repository.deleteById(id);
	}
	
	public void delete(Societe societe) {
		repository.delete(societe);
	}
	
	
}
