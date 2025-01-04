package com.storeproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.storeproject.entity.PurchaseProduct;
import com.storeproject.serviceImp.PurchaseProductServiceImp;

@RestController
@RequestMapping("/api/purchase-products")
@CrossOrigin(origins = "http://localhost:3000/")
public class PurchaseProductsController {

	@Autowired
	private PurchaseProductServiceImp purchaseProductServiceImp;


	@GetMapping(value = "/find/{purchaseId}")
	public Optional<PurchaseProduct> getSingleInfo(@PathVariable int purchaseId){
		Optional<PurchaseProduct> singleData = purchaseProductServiceImp.getSingleData(purchaseId);
		return singleData;
	}

	@PostMapping(value = "/add")
	public ResponseEntity<String> addPurchaseProductBatch(@RequestBody List<PurchaseProduct> purchaseProductList) {
		purchaseProductServiceImp.insertPurchaseProducts(purchaseProductList);
		return ResponseEntity.status(HttpStatus.CREATED).body("Purchase Products added successfully and Store quantities updated!");
	}

	@GetMapping(value = "/findall")
	public ResponseEntity<List<PurchaseProduct>> getAllPurchaseProductInfo() {
		List<PurchaseProduct> allPurchaseProducts = purchaseProductServiceImp.getAllPurchaseProducts();
		return ResponseEntity.ok(allPurchaseProducts);
	}

	@PutMapping(value = "/update/{purchaseId}/store/{storeId}")
	public ResponseEntity<String> updatePurchaseAndStoreProduct(
			@PathVariable int purchaseId,
			@RequestParam String purchaseProductName,
			@PathVariable int storeId,
			@RequestParam long quantity,
			@RequestParam String operation) {

		// Call the combined service method
		purchaseProductServiceImp.updatePurchaseAndStoreProduct(purchaseId, purchaseProductName , storeId, quantity, operation);

		return ResponseEntity.ok("Purchase Product and Store Product quantity updated successfully");
	}
}
