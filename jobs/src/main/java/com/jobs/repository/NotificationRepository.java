package com.jobs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jobs.model.Notification;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Integer>{

}
