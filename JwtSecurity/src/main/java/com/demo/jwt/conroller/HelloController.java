package com.demo.jwt.conroller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000/")
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello, JWT authenticated user!";	
	}
}
