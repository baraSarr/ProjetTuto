package com.jobs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobs.model.Experience;
import com.jobs.repository.ExperienceRepository;

@Service
public class ExperienceService {

	@Autowired
	private ExperienceRepository repository;
	
	public Experience create(Experience experience) {
		return repository.save(experience);
	}
	
	public Optional<Experience> read(int id){
		return repository.findById(id);
	}
	
	public Iterable<Experience> readAll(){
		return repository.findAll();
	}
	
	public Experience update(Experience experience) {
		return repository.save(experience);
	}
	
	public void delete(int id) {
		repository.deleteById(id);
	}
	
	public void delete(Experience experience) {
		repository.delete(experience);
	}
}
