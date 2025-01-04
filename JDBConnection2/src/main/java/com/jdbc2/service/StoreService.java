package com.jdbc2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jdbc2.model.Store;

@Service
public interface StoreService {
	
	int createProduct(Store store);
	
	List<Store> findAllProduct();
	
	Store findIdProduct(int productID);
	
	int updateData(Store store);
	
	int deteteData(int productID);
 
}
