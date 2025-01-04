package com.costom.sec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.costom.sec.entity.Role;
import com.costom.sec.entity.User;
import com.costom.sec.serviceimp.UserServiceImp;

@RestController
@CrossOrigin("http://localhost:3000/")
public class AuthController {
	
	@Autowired
	UserServiceImp userServiceImp;
	
	@GetMapping("/register")
	public String showRegisterationForm(Model model) {
		User user =new User();
		
		List<Role> roles = userServiceImp.getAllRole();
		model.addAttribute("user", user);
		model.addAttribute("roles", roles);
		return "register";
		
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") User user, String roleName , Model model) {
		if(userServiceImp.findByUserName(user.getUsername()) != null) {
			model.addAttribute("error" , "Username is already taken");
			return "register";
	}
		userServiceImp.registerUser(user, roleName);
		return "register:/login";
		
	}
	
	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}
}
