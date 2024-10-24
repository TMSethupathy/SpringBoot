package com.procedure.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.procedure.model.Products;
import com.procedure.repo.ProductsRepo;
import com.procedure.service.ProductService;

@Component
public class ProductServiceImp implements ProductService{

	@Autowired
	ProductsRepo productsRepo;
	
	@Override
	public List<Products> findAllProduct() {	
		return productsRepo.findAll() ;
	}

}
