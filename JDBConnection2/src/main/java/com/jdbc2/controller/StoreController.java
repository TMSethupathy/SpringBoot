package com.jdbc2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jdbc2.model.Store;
import com.jdbc2.serviceimp.StoreServiceImp;

@RestController
public class StoreController {
	
	@Autowired
	StoreServiceImp ssi;
	
	
	@PostMapping(value="/save")
	public int createProductInfo(@RequestBody Store store) {
		int createProduct = ssi.createProduct(store);
		return createProduct;
	}
	
	@GetMapping(value="/store")
	public List<Store> findAllInfo(){
		List<Store> findAllProduct = ssi.findAllProduct();
		return findAllProduct;
	}
	
	@GetMapping(value="/storeId/{productID}")
	public Store findIdProductInfo(@PathVariable int productID) {
		Store findIdProduct = ssi.findIdProduct(productID);
		return findIdProduct;
	}
	
	@PutMapping(value="/update")
	public int updateInfo(@RequestBody Store store) {
		int updateData = ssi.updateData(store);
		return updateData;
	}
	
	@DeleteMapping(value="/delete/{productID}")
	public int deleteInfo(@PathVariable int productID) {
		int deteteData = ssi.deteteData(productID);
		return deteteData;
	}
	
}


