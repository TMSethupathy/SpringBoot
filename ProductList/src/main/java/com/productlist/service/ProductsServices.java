package com.productlist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.productlist.entity.Products;

@Service
public interface ProductsServices {
	
	Products createPurchase(Products products);
	
	List<Products> findAllProducts();

}
