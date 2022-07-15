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
@Table(name="experiences")
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_experience")
	private int idExperience;
	
	@Size(min = 2, message = "un minimum de 2 lettres est nécessaire")
	@NotBlank(message = "le nom de la société ne doit pas être vide")
	@Column(name = "nom_societe")
	private String nomSociete;
	
	@Size(min = 2, message = "un minimum de 2 lettres est nécessaire")
	@NotBlank(message = "le nom du poste ne doit pas être vide")
	@Column(name = "poste_occupe")
	private String posteOccupe;
	
	@Size(min = 4, message = "un minimum de 4 lettres est nécessaire")
	@NotBlank(message = "la date de début ne doit pas être vide")
	@Column(name = "date_debut")
	private String dateDebut;
	
	@Size(min = 4, message = "un minimum de 4 lettres est nécessaire")
	@NotBlank(message = "la date de fin ne doit pas être vide")
	@Column(name = "date_Fin")
	private String dateFin;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne(
			cascade = CascadeType.MERGE
                                      )
	@JoinColumn(name="id_user")
	@ToString.Exclude
	private Utilisateur utilisateur;
	
}
