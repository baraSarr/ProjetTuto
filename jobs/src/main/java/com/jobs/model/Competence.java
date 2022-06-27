package com.jobs.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="competences")
public class Competence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_competence")
	private int idCompetence;
	
	@Column(name = "nom")
	private String nom;
	
	@ManyToMany(
			mappedBy = "competences",
			cascade = CascadeType.ALL
			)
	@ToString.Exclude
	private List<Utilisateur> utilisateurs = new ArrayList<>();
	
	@ManyToMany(
			mappedBy = "prerequis",
			cascade = CascadeType.ALL
			)
	@ToString.Exclude
	private List<Offre> offres = new ArrayList<>();
	
}
