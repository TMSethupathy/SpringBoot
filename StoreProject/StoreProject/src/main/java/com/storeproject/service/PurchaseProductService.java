package com.storeproject.service;

import java.util.List;
import java.util.Optional;

import com.storeproject.entity.PurchaseProduct;

public interface PurchaseProductService {

	void insertPurchaseProducts(List<PurchaseProduct> purchaseProductList);

	List<PurchaseProduct> getAllPurchaseProducts();

	void updatePurchaseAndStoreProduct(int purchaseId, String purchaseProductName,
									   int storeId, long quantity, String operation);

	Optional<PurchaseProduct>  getSingleData(int purchaseId);

}

