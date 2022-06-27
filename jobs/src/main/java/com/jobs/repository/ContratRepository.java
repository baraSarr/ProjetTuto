package com.jobs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jobs.model.Contrat;

@Repository
public interface ContratRepository extends CrudRepository<Contrat, Integer>{

}
