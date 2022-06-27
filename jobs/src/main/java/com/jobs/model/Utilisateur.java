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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="utilisateurs")
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int idUser;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "profil")
	private String profil;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "adresse")
	private String adresse;
	
	@Column(name = "num_tel")
	private String numTel;
	
	@Column(name = "photo_profil")
	private String photo_profil;
	
	@OneToMany(
			   cascade = CascadeType.ALL, 
			   orphanRemoval = true, 
			   fetch = FetchType.LAZY
			   )
	@JoinColumn(name = "id_user")
	@ToString.Exclude
	private List<Experience> experiences = new ArrayList<>();
	
	@OneToMany(
			   cascade = CascadeType.ALL, 
			   orphanRemoval = true, 
			   fetch = FetchType.LAZY
			   )
	@JoinColumn(name = "id_destinataire")
	@ToString.Exclude
	private List<Notification> notificationsRecues = new ArrayList<>();
	
	@OneToMany(
			   cascade = CascadeType.ALL, 
			   orphanRemoval = true, 
			   fetch = FetchType.LAZY
			   )
	@JoinColumn(name = "id_user")
	@ToString.Exclude
	private List<Formation> formations = new ArrayList<>();
	
	@OneToMany(
			   cascade = CascadeType.ALL, 
			   orphanRemoval = true, 
			   fetch = FetchType.EAGER
			   )
	@JoinColumn(name = "id_user")
	@ToString.Exclude
	private List<Offre> offresPostees = new ArrayList<>();
	
	
	@ManyToMany(
			fetch = FetchType.LAZY,
				cascade = { 
						CascadeType.PERSIST, 
						CascadeType.MERGE 
						}	
				)
	@JoinTable(
				name = "posseder",
				joinColumns = @JoinColumn(name = "id_user"), 	
				inverseJoinColumns = @JoinColumn(name = "id_competence")
				)
	@ToString.Exclude
	private List<Competence> competences = new ArrayList<>();	
	
	@ManyToMany(
			mappedBy = "postulants",
			cascade = CascadeType.ALL
			)
	@ToString.Exclude
	private List<Offre> offresPostulees = new ArrayList<>();

	
	
}
