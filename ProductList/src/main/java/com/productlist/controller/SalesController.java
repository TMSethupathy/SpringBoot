package com.productlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productlist.dto.SalesDTO;
import com.productlist.serviceimp.SalesServiceImp;

@RestController
@CrossOrigin(origins = "http://localhost:5173") 
public class SalesController {
	
	@Autowired
	SalesServiceImp salesServiceImp;
	
	
	@PostMapping(value = "/sales")
	public ResponseEntity<String> createSalesInfo(@RequestBody SalesDTO salesDTO){
		salesServiceImp.createSales(salesDTO);
		return ResponseEntity.ok("saved");
	}

	@GetMapping(value = "/findSales")
	public List<SalesDTO> findAllSalesInfo(){
		List<SalesDTO> findAllSales = salesServiceImp.findAllSales();
		return findAllSales;
	}
}
