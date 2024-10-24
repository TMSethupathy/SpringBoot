package com.procedure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.procedure.model.Purchases;
import com.procedure.serviceimp.PurchasesServiceImp;

@RestController
@CrossOrigin(origins = "http://localhost:5173") 
public class PurchasesController {
	
	@Autowired
	PurchasesServiceImp purchasesServiceImp;
	
	@GetMapping(value = "purchases")
	public List<Purchases> findAllPurchaseInfo(){
		List<Purchases> findAllPurchase = purchasesServiceImp.findAllPurchase();
		return findAllPurchase;
	}

}
