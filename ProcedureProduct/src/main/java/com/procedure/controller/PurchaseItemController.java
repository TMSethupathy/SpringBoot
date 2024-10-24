package com.procedure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.procedure.model.PurchaseItem;
import com.procedure.serviceimp.PurchaseItemServiceImp;

@RestController
@CrossOrigin(origins = "http://localhost:5173") 
public class PurchaseItemController {
	
	@Autowired
	PurchaseItemServiceImp purchaseItemServiceImp;
	
	@GetMapping(value = "purchaseitem")
	public List<PurchaseItem> findAllPurchaseItemInfo(){
		List<PurchaseItem> findAllPurchase = purchaseItemServiceImp.findAllPurchase();
		return findAllPurchase;
	}
}
