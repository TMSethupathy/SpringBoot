package com.demo.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.jwt.entity.User;
import com.demo.jwt.entity.repo.UserRepo;

@Service
@Component
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void registerUser(String username,String password) {
		
		User user =new User();
		
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(password));
		user.setRole("ROLE_USER");
		userRepo.save(user);
		
	}

}
