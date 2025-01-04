package com.basic.sec.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SecController {
		
	@GetMapping("/find")
	public ResponseEntity<String> findResource() {
	return ResponseEntity.ok("Resource found");
		  
	  }
}