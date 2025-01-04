package com.demo.jwt.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.jwt.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:3000/")
public class RegisterController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestParam String username,
										   @RequestParam String password){
		userService.registerUser(username, password);
		return ResponseEntity.ok("User registered successfully");		
	}
}
