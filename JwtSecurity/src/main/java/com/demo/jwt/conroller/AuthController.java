package com.demo.jwt.conroller;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.jwt.config.JwtUtils;
import com.demo.jwt.service.CustomUserDetailsService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:3000/")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/login")
	public String login(@RequestParam String  username, @RequestParam String password) throws AuthenticationException {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
		return jwtUtils.generateToken(userDetails.getUsername()) ;	
	}
}
