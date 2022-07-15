package com.jobs.model;

import java.beans.Transient;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobs.service.CompetenceService;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="utilisateurs", uniqueConstraints = @UniqueConstraint(columnNames={"login"}))
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int idUser;
	
	@Size(min = 2, message = "Un prénom doit avoir au minimum 2 lettres")
	@NotBlank(message = "Veuillez saisir votre prénom")
	@Column(name = "prenom")
	private String prenom;
	
	@Size(min = 2, message = "Un nom doit avoir au minimum 2 lettres")
	@NotBlank(message = "Veuillez saisir votre nom")
	@Column(name = "nom")
	private String nom;
	
	@Email(message = "Veuillez saisir une adresse mail valide")
	@NotBlank(message = "Veuillez saisir votre adresse mail")
	@Column(name = "login")
	private String login;
	
	@NotBlank(message = "Veuillez saisir votre mot de passe")
	@JsonIgnore
	@Column(name = "password")
	private String password;
	
	@NotBlank(message = "Veuillez saisir votre adresse")
	@Column(name = "adresse")
	private String adresse;
	
	@NotBlank(message = "Veuillez saisir votre numéro de téléphone")
	@Column(name = "num_tel")
	private String numTel;
	
	@Column(name = "photo_profil")
	private String photoProfil;
	
	@Transient
    public String getPhotosImagePath() {
        if (photoProfil == null || idUser == 0) return null;
         
        return "/user-photos/" + idUser + "/" + photoProfil;
    }
	
	@ManyToOne(
			cascade = CascadeType.ALL
                                      )
	@JoinColumn(name="id_role")
	@ToString.Exclude
	private Role role;
	
	@OneToMany(
			   cascade = CascadeType.MERGE, 
			   orphanRemoval = true, 
			   fetch = FetchType.LAZY
			   )
	@JoinColumn(name = "id_user")
	@ToString.Exclude
	private List<Experience> experiences = new ArrayList<>();
	
	@OneToMany(
			   cascade = CascadeType.MERGE, 
			   orphanRemoval = true, 
			   fetch = FetchType.LAZY
			   )
	@JoinColumn(name = "id_destinataire")
	@ToString.Exclude
	private List<Notification> notificationsRecues = new ArrayList<>();
	
	@OneToMany(
			   cascade = CascadeType.MERGE, 
			   orphanRemoval = true, 
			   fetch = FetchType.LAZY
			   )
	@JoinColumn(name = "id_user")
	@ToString.Exclude
	private List<Formation> formations = new ArrayList<>();
	
	@OneToMany(
			   cascade = CascadeType.MERGE, 
			   orphanRemoval = true, 
			   fetch = FetchType.LAZY
			   )
	@JoinColumn(name = "id_user")
	@ToString.Exclude
	private List<Offre> offresPostees = new ArrayList<>();
	
	
	@ManyToMany(
			fetch = FetchType.LAZY,
				cascade = { 
						CascadeType.MERGE, 
						CascadeType.PERSIST 
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
			cascade = CascadeType.MERGE
			)
	@ToString.Exclude
	private List<Offre> offresPostulees = new ArrayList<>();

	
}
