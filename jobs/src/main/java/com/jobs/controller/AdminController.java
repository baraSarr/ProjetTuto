package com.jobs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jobs.model.Utilisateur;
import com.jobs.service.UtilisateurService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private UtilisateurService userService;

	@GetMapping("/dashboard")
	public String adminDashboard() {
		return "dashboard_admin";
	}
	
	@GetMapping("/utilisateurs")
	public String utilisateurs(Model model) {
		List<Utilisateur> users = (List<Utilisateur>) userService.readAll();
		model.addAttribute("users", users);
		return "user_list";
	}
	
	@GetMapping("/users/delete/{id}")
	public ModelAndView delUser(@PathVariable("id") final int id) {
		userService.delete(id);
		return new ModelAndView("redirect:/utilisateurs");	
	}
	
	@GetMapping("/users/update/{id}")
	public String updateUser(@PathVariable("id") final int id, Model model) {
		Utilisateur user = userService.read(id).get();
		model.addAttribute("user", user);
		return "modifUser_form";
	}
	
	public String updateUser(@Valid @ModelAttribute Utilisateur user, BindingResult bindingResult, Model model) {
		model.addAttribute("success", null);
		if(bindingResult.hasErrors()) {
			return "modifUser_form";
		}
		else {
			userService.update(user);
			String message = "Utilisateur modifié avec succès";
			model.addAttribute("success", message);
			return "modifUser_form";
		}
	}
}
