package com.jobs;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jobs.model.Competence;
import com.jobs.model.Utilisateur;
import com.jobs.service.CompetenceService;
import com.jobs.service.UtilisateurService;

@SpringBootApplication
public class JobsApplication implements CommandLineRunner{

	@Autowired
	private UtilisateurService us;
	
	public static void main(String[] args) {
		SpringApplication.run(JobsApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Optional<Utilisateur> usero = us.read(1);
		Utilisateur user = usero.get();
		user.getNotificationsRecues().forEach(exp -> System.out.println(exp.getObjet()));
	}

}
