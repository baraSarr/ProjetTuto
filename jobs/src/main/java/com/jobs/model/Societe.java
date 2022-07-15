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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="societes")
public class Societe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_societe")
	private int IdSociete;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "adresse")
	private String adresse;
	
	@Column(name = "telephone")
	private String telephone;
	
	@Column(name = "mail")
	private String mail;
	
	@OneToMany(
			   cascade = CascadeType.ALL, 
			   orphanRemoval = true, 
			   fetch = FetchType.LAZY
			   )
	@JoinColumn(name = "id_societe")
	@ToString.Exclude
	private List<Offre> offres = new ArrayList<>();
	
}
