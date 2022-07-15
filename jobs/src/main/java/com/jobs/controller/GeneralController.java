package com.jobs.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jobs.config.FileUploadUtil;
import com.jobs.model.Utilisateur;
import com.jobs.service.RoleService;
import com.jobs.service.UtilisateurService;

@Controller
public class GeneralController {
	
	@Autowired
	private UtilisateurService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public String home() {        
		return "home";
	}
	
	@GetMapping("/orientation")
	public String orientation() {        
		return "orientation";
	}
	
	@GetMapping("/inscription")
	public String inscription(Model model) {
		Utilisateur user = new Utilisateur();
		model.addAttribute("utilisateur", user);
		return "page_inscription";
	}
	
	@RequestMapping(value = "/inscription", method=RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute Utilisateur user, BindingResult bindingResult,
			Model model, @RequestParam("image") MultipartFile multipartFile) {
		model.addAttribute("erreur_login", null);
		model.addAttribute("erreur_file", null);
		try {
			if (bindingResult.hasErrors()) {            
			    return "page_inscription";
			} else {
				String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
				String encryptedPassword = passwordEncoder.encode(user.getPassword()); 
				user.setPassword(encryptedPassword);
				user.setRole(roleService.read(2).get());
				user.setPhotoProfil(fileName);
				Utilisateur savedUser = userService.create(user);
				String uploadDir = "user-photos/" + savedUser.getIdUser();
				FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
			    return "registration_successful";
			}
		}catch(IOException ioException) {
			model.addAttribute("erreur_file", "fichier invalide");
			return "page_inscription";
		}
		catch (Exception e) {
			model.addAttribute("erreur_login", "cet email a déjà été enregistré");
			return "page_inscription";
		}
	}
	
	@GetMapping("/connexion")
	public String connexion(Model model) {
		Utilisateur user = new Utilisateur();
		model.addAttribute("utilisateur", user);
		return "page_connexion";
	}
	
	@RequestMapping(value = "/connexion/authentifier")
	public String authentifier(@ModelAttribute Utilisateur user, HttpServletRequest request,
			RedirectAttributes attr) {
		Authentication authentication;
		try {
			authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			Utilisateur userAuth = userService.findAccount(user.getLogin()).get();
			request.getSession(true).setAttribute("user", userAuth);
			if(userAuth.getRole().getNom().equals(roleService.read(1).get().getNom())) {
				return "redirect:/admin/dashboard";
			}
			else {
				return "redirect:/utilisateur/dashboard";
			}
		}catch (BadCredentialsException e) {
			attr.addFlashAttribute("echec", "informations incorrectes");
			return "redirect:/connexion";
		}
		
	}
	
	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "Logout");
		return "logoutSuccessfulPage";
	}
	
	
}
