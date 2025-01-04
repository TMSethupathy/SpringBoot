package com.costom.sec.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000/")
public class DashboardController {
	
	@GetMapping("/admin")
	public String adminDeshboard() {
		return "admin";
		
	}
	
	@GetMapping("/user")
	public String userDashboard() {
		return "user";
	}

}
