package com.productlist.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.productlist.entity.Products;
import com.productlist.repo.ProductsRepo;
import com.productlist.service.ProductsServices;

@Component
public class ProductsServiceImp implements ProductsServices{

	@Autowired
	ProductsRepo productsRepo;
	
	@Override
	public Products createPurchase(Products products) {
		Products save = productsRepo.save(products);
		return save;
	}

	@Override
	public List<Products> findAllProducts() {
		List<Products> findAll = productsRepo.findAll();
		return findAll;
	}

}
