package com.productlist.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productlist.dto.PurchasesDTO;
import com.productlist.serviceimp.PurchasesServiceImp;


@RestController
@CrossOrigin(origins = "http://localhost:5173") 
public class PurchasesController {
	
	@Autowired
	PurchasesServiceImp purchasesServiceImp;
	
	@PostMapping(value = "purchases")
	public ResponseEntity<String> createPurchasesInfo(@RequestBody PurchasesDTO purchasesDto) {
		purchasesServiceImp.createPurchases(purchasesDto);
		return ResponseEntity.ok("saved") ;
	}
	
	@GetMapping(value = "/findPurchases")
	public List<PurchasesDTO> findAllPurchasesInfo(){
		List<PurchasesDTO> allPurchases = purchasesServiceImp.getAllPurchases();
		return allPurchases;
	}
		
	@PutMapping(value = "/updatepurchase/{purchaseId}")
	public ResponseEntity<String> editPurchaseInfo(@PathVariable int purchaseId,@RequestBody PurchasesDTO purchasesDto){
		purchasesServiceImp.editPurchase(purchaseId, purchasesDto);
		return ResponseEntity.ok("update");
	}
	
}
