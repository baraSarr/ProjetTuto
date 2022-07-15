package com.jobs.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jobs.model.Utilisateur;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UtilisateurService service;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Utilisateur user = service.findAccount(login).orElseThrow(
				() -> new UsernameNotFoundException("User not found")
				);
		Set<SimpleGrantedAuthority> list = new HashSet<>();
		list.add(new SimpleGrantedAuthority(user.getRole().getNom()));
		return new org.springframework.security.core.userdetails.User(user.getLogin(),user.getPassword(), list);
	}

}
