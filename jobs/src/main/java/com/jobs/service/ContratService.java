package com.jobs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobs.model.Contrat;
import com.jobs.repository.ContratRepository;

@Service
public class ContratService {

	@Autowired
	private ContratRepository repository;
	
	public Contrat create(Contrat contrat) {
		return repository.save(contrat);
	}
	
	public Optional<Contrat> read(int id){
		return repository.findById(id);
	}
	
	public Iterable<Contrat> readAll(){
		return repository.findAll();
	}
	
	public Contrat update(Contrat contrat) {
		return repository.save(contrat);
	}
	
	public void delete(int id) {
		repository.deleteById(id);
	}
	
	public void delete(Contrat contrat) {
		repository.delete(contrat);
	}
}
