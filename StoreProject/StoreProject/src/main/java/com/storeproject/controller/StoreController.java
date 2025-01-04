package com.storeproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.storeproject.entity.Store;
import com.storeproject.serviceImp.StoreServiceImp;

@RestController
@RequestMapping("/api/store-products")
@CrossOrigin(origins = "http://localhost:3000/")
public class StoreController {

	@Autowired
	private  StoreServiceImp serviceImp;


	@PostMapping("/save")
	public ResponseEntity<String> saveBatchDataInfo(@RequestBody List<Store> storeList) {
		serviceImp.insertBatchData(storeList);
		return ResponseEntity.status(HttpStatus.CREATED).body("Batch added successfully");
	}


	@GetMapping(value = "/findall")
	public List<Store> getAllData() {
		return serviceImp.getStore();
	}
}
