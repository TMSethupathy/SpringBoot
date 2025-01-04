package com.productlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productlist.entity.Products;
import com.productlist.serviceimp.ProductsServiceImp;

@RestController
@CrossOrigin(origins = "http://localhost:5173") 
public class ProductsController {
	
	@Autowired
	ProductsServiceImp productsServiceImp;
	
	
	@PostMapping(value = "/product")
	public Products createProductInfo(@RequestBody Products products) {
		Products createPurchase = productsServiceImp.createPurchase(products);
		return createPurchase;
	}

	@GetMapping(value = "/findProduct")
	public List<Products> findAllProducts(){
		List<Products> findAllProducts = productsServiceImp.findAllProducts();
		return findAllProducts;
	}
}
