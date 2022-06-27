package com.jobs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jobs.model.Competence;

@Repository
public interface CompetenceRepository extends CrudRepository<Competence, Integer>{

}
