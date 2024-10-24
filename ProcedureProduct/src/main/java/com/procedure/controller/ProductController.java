package com.procedure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.procedure.model.Products;
import com.procedure.serviceimp.ProductServiceImp;

@RestController
@CrossOrigin(origins = "http://localhost:5173") 
public class ProductController {

	@Autowired
	ProductServiceImp productServiceImp;
	
	@GetMapping(value = "/findproduct")
	public List<Products> findAllProductInfo(){
		List<Products> findAllProduct = productServiceImp.findAllProduct();
		return findAllProduct;
	}
}
