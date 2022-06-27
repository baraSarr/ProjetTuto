package com.jobs.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="offres")
public class Offre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_offre")
	private int IdOffre;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "niveau_experience")
	private String niveauExperience;
	
	@Column(name = "niveau_etude")
	private String niveauEtude;
	
	@Column(name = "poste_propose")
	private String postePropose;
	
	@ManyToOne(
			cascade = CascadeType.ALL
                                      )
	@JoinColumn(name="id_user")
	@ToString.Exclude
	private Utilisateur recruteur;
	
	@ManyToOne(
			cascade = CascadeType.ALL
                                      )
	@JoinColumn(name="id_societe")
	@ToString.Exclude
	private Societe societe;
	
	@ManyToMany(
			fetch = FetchType.LAZY,
				cascade = { 
						CascadeType.PERSIST, 
						CascadeType.MERGE 
						}	
				)
	@JoinTable(
				name = "postuler",
				joinColumns = @JoinColumn(name = "id_offre"), 	
				inverseJoinColumns = @JoinColumn(name = "id_user")
				)
	@ToString.Exclude
	private List<Utilisateur> postulants = new ArrayList<>();
	
	@ManyToMany(
			fetch = FetchType.LAZY,
				cascade = { 
						CascadeType.PERSIST, 
						CascadeType.MERGE 
						}	
				)
	@JoinTable(
				name = "demander",
				joinColumns = @JoinColumn(name = "id_offre"), 	
				inverseJoinColumns = @JoinColumn(name = "id_competence")
				)
	@ToString.Exclude
	private List<Competence> prerequis = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contrat", referencedColumnName = "id_contrat")
	@ToString.Exclude
    private Contrat contrat;
}
