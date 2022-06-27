package com.jobs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jobs.model.Formation;

@Repository
public interface FormationRepository extends CrudRepository<Formation, Integer>{

}
