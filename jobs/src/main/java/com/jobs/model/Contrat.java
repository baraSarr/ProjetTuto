package com.jobs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="contrats")
public class Contrat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contrat")
	private int idContrat;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "duree")
	private String duree;
	
	@Column(name = "salaire")
	private String salaire;
	
	@OneToOne(mappedBy = "contrat")
	@ToString.Exclude
    private Offre offre;
}
