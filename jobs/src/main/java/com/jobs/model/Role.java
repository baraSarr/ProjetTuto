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
@Table(name="roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_role")
	private int idRole;
	
	@Column(name = "nom")
	private String nom;
	
	@OneToMany(
			   cascade = CascadeType.ALL, 
			   orphanRemoval = true, 
			   fetch = FetchType.LAZY
			   )
	@JoinColumn(name = "id_role")
	@ToString.Exclude
	private List<Utilisateur> utilisateurs = new ArrayList<>();
}
