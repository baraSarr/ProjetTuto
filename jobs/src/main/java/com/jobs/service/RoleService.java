package com.jobs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobs.model.Role;
import com.jobs.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository repository;
	
	public Role create(Role role) {
		return repository.save(role);
	}
	
	public Optional<Role> read(int id){
		return repository.findById(id);
	}
	
	public Iterable<Role> readAll(){
		return repository.findAll();
	}
	
	public Role update(Role role) {
		return repository.save(role);
	}
	
	public void delete(int id) {
		repository.deleteById(id);
	}
	
	public void delete(Role role) {
		repository.delete(role);
	}
}
