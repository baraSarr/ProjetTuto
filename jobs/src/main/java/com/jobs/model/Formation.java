package com.jobs.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "formations")
public class Formation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_formation")
	private int idFormation;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "intitule")
	private String intitule;
	
	@Column(name = "nom_ecole")
	private String nomEcole;
	
	@Column(name = "annee_debut")
	private String anneeDebut;
	
	@Column(name = "annee_fin")
	private String anneeFin;
	
	@ManyToOne(
			cascade = CascadeType.ALL
                                      )
	@JoinColumn(name="id_user")
	@ToString.Exclude
	private Utilisateur utilisateur;
}
