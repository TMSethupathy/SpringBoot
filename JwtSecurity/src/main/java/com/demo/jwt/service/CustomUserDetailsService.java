package com.demo.jwt.service;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.jwt.entity.User;
import com.demo.jwt.entity.repo.UserRepo;

@Service
@Component
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException("User not found"));
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),Collections.emptyList());
	}

}
