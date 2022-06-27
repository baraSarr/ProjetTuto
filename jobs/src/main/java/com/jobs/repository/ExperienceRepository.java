package com.jobs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jobs.model.Experience;

@Repository
public interface ExperienceRepository extends CrudRepository<Experience, Integer>{

}
