package com.jobs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jobs.model.Societe;

@Repository
public interface SocieteRepository extends CrudRepository<Societe, Integer>{

}
