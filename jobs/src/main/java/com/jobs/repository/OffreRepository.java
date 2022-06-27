package com.jobs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jobs.model.Offre;

@Repository
public interface OffreRepository extends CrudRepository<Offre, Integer>{

}
