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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
	
	@Size(min = 2, message = "un minimum de 2 lettres est nécessaire")
	@NotBlank(message = "l'intitulé de la formation ne doit pas être vide")
	@Column(name = "intitule")
	private String intitule;
	
	@Size(min = 2, message = "un minimum de 2 lettres est nécessaire")
	@NotBlank(message = "le nom de l'établissement ne doit pas être vide")
	@Column(name = "nom_ecole")
	private String nomEcole;
	
	@Size(min = 4, message = "le format de l'année n'est pas respecté")
	@NotBlank(message = "l'année de début ne doit pas être vide")
	@Column(name = "annee_debut")
	private String anneeDebut;
	
	@Size(min = 4, message = "le format de l'année n'est pas respecté")
	@NotBlank(message = "l'année de fin ne doit pas être vide")
	@Column(name = "annee_fin")
	private String anneeFin;
	
	@ManyToOne(
			cascade = CascadeType.MERGE
                                      )
	@JoinColumn(name="id_user")
	@ToString.Exclude
	private Utilisateur utilisateur;
}
