package com.jobs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobs.model.Offre;
import com.jobs.repository.OffreRepository;

@Service
public class OffreService {

	@Autowired
	private OffreRepository repository;
	
	public Offre create(Offre offre) {
		return repository.save(offre);
	}
	
	public Optional<Offre> read(int id){
		return repository.findById(id);
	}
	
	public Iterable<Offre> readAll(){
		return repository.findAll();
	}
	
	public Offre update(Offre offre) {
		return repository.save(offre);
	}
	
	public void delete(int id) {
		repository.deleteById(id);
	}
	
	public void delete(Offre offre) {
		repository.delete(offre);
	}
}
