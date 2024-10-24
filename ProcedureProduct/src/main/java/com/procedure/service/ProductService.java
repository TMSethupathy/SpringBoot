package com.procedure.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.procedure.model.Products;

@Service
public interface ProductService {
	
	List<Products> findAllProduct();
}
