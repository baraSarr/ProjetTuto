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
@Table(name="experiences")
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_experience")
	private int idExperience;
	
	@Column(name = "nom_societe")
	private String nomSociete;
	
	@Column(name = "poste_occupe")
	private String posteOccupe;
	
	@Column(name = "date_debut")
	private String dateDebut;
	
	@Column(name = "date_Fin")
	private String dateFin;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne(
			cascade = CascadeType.ALL
                                      )
	@JoinColumn(name="id_user")
	@ToString.Exclude
	private Utilisateur utilisateur;
	
}
