package com.jdbc2.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jdbc2.model.Store;
import com.jdbc2.repo.StoreRepo;
import com.jdbc2.service.StoreService;

@Component
public class StoreServiceImp implements StoreService{

	@Autowired
	StoreRepo sr;
	
	@Override
	public int createProduct(Store store) {
		int save = sr.save(store);
		return save;
		
	}

	@Override
	public List<Store> findAllProduct() {
		List<Store> findAll = sr.findAll();
		return findAll;
	}

	@Override
	public Store findIdProduct(int productID) {
		Store findById = sr.findById(productID);
		return findById;
	}

	@Override
	public int updateData(Store store) {
		int update = sr.update(store);
		return update;
	}

	@Override
	public int deteteData(int productID) {
		int detete = sr.detete(productID);
		return detete;
	}
	

}
