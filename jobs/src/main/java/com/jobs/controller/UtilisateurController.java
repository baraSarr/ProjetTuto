package com.jobs.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jobs.model.Competence;
import com.jobs.model.Experience;
import com.jobs.model.Formation;
import com.jobs.model.Offre;
import com.jobs.model.Utilisateur;
import com.jobs.service.CompetenceService;
import com.jobs.service.ExperienceService;
import com.jobs.service.FormationService;
import com.jobs.service.OffreService;
import com.jobs.service.UtilisateurService;

@Controller
@RequestMapping(value = "/utilisateur")
public class UtilisateurController {
	
	@Autowired
	private UtilisateurService userService;
	
	
	@Autowired
	private FormationService formationService;
	
	@Autowired
	private ExperienceService experienceService;
	
	@Autowired
	private CompetenceService competenceService;
	
	@Autowired
	private OffreService offreService;
	
	
	@GetMapping("/dashboard")
	public String userDashboard() {
		return "dashboard_user";
	}
	
	@GetMapping("/dashboard/formations")
	public String formations(Model model, HttpServletRequest request) {
		Utilisateur user = (Utilisateur) (Utilisateur) request.getSession().getAttribute("user");
		List<Formation> formations = (List<Formation>) formationService.findByUser(user);
		model.addAttribute("formations",formations);
		return "user_formations";
	}
	
	@GetMapping("/dashboard/formations/add")
	public String addFormation(Model model) {
		Formation formation = new Formation();
		model.addAttribute("formation", formation);
		return "add_formation";
	}
	
	@RequestMapping("/dashboard/formations/add")
	public String addFormation(@Valid @ModelAttribute Formation formation, BindingResult bindingResult, HttpServletRequest request,
			RedirectAttributes attr) {
		if(bindingResult.hasErrors()) {
			return "add_formation";
		}
		else {
			Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");
			formation.setUtilisateur(user);
			formationService.create(formation);
			attr.addFlashAttribute("success", "Formation Ajoutée avec succès");
			return "redirect:/utilisateur/dashboard/formations/add";
		}
	}
	
	@GetMapping("/dashboard/experiences")
	public String experiences(Model model, HttpServletRequest request) {
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");
		List<Experience> experiences = (List<Experience>) experienceService.findByUser(user);
		model.addAttribute("experiences", experiences);
		return "user_experiences";
	}
	
	@GetMapping("/dashboard/experiences/add")
	public String addExperience(Model model) {
		Experience experience = new Experience();
		model.addAttribute("experience", experience);
		return "add_experience";
	}
	
	@RequestMapping("/dashboard/experiences/add")
	public String addExperience(@Valid @ModelAttribute Experience experience, BindingResult bindingResult, HttpServletRequest request,
			RedirectAttributes attr) {
		if(bindingResult.hasErrors()) {
			return "add_experience";
		}
		else {
			Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");
			experience.setUtilisateur(user);
			experienceService.create(experience);
			attr.addFlashAttribute("success", "expérience Ajoutée avec succès");
			return "redirect:/utilisateur/dashboard/experiences/add";
		}
	}
	
	@GetMapping("/dashboard/competences")
	public String competences(Model model, HttpServletRequest request) {
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");
		List<Utilisateur> users = new ArrayList<>();
		users.add(user);
		List<Competence> competences = new ArrayList<>();
		competences = (List<Competence>) competenceService.findByUser(users);
		model.addAttribute("competences", competences);
		return "user_competences";
	}
	
	@GetMapping("/dashboard/competences/add")
	public String addCompetence(Model model) {
		List<Competence> competences = (List<Competence>) competenceService.readAll();
		model.addAttribute("competences", competences);
		return "add_competence";
	}
	
	@RequestMapping("/dashboard/competences/add/{id}")
	public String addCompetence(@PathVariable("id") final int id, HttpServletRequest request,RedirectAttributes attr) {
		Competence competence = competenceService.read(id).get();
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");
		List<Utilisateur> users = new ArrayList<>();
		users.add(user);
		List<Competence> comps = new ArrayList<>();
		comps = (List<Competence>) competenceService.findByUser(users);
		comps.add(competence);
		user.setCompetences(comps);
		userService.update(user);
		attr.addFlashAttribute("success", "Compétence Ajoutée avec succès");
		return "redirect:/utilisateur/dashboard/competences/add";
	}
	
	@GetMapping("/offres")
	public String offres(Model model, HttpServletRequest request) {
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");
		List<Offre> offres = (List<Offre>) offreService.findByRecruteur(user);
		model.addAttribute("offres", offres);
		return "user_offres";
	}
	
	public String addOffre(Model model) {
		Offre offre = new Offre();
		model.addAttribute(offre);
		return "add_offre";
	}
	
	@GetMapping("/candidatures")
	public String candidatures(Model model, HttpServletRequest request) {
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");
		List<Utilisateur> users = new ArrayList<>();
		users.add(user);
		List<Offre> candidatures = (List<Offre>) offreService.findByPostulantsIn(users);
		model.addAttribute("candidatures", candidatures);
		return "user_candidatures";
	}
}
