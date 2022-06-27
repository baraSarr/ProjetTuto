package com.jobs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobs.model.Notification;
import com.jobs.repository.NotificationRepository;

@Service
public class NotificationService {
	
	@Autowired
	private NotificationRepository repository;
	
	public Notification create(Notification notification) {
		return repository.save(notification);
	}
	
	public Optional<Notification> read(int id){
		return repository.findById(id);
	}
	
	public Iterable<Notification> readAll(){
		return repository.findAll();
	}
	
	public Notification update(Notification notification) {
		return repository.save(notification);
	}
	
	public void delete(int id) {
		repository.deleteById(id);
	}
	
	public void delete(Notification notification) {
		repository.delete(notification);
	}

}
