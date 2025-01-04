package com.storeproject.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.storeproject.entity.PurchaseProduct;
import com.storeproject.repo.PurchaseProductRepo;
import com.storeproject.repo.StoreRepo;
import com.storeproject.service.PurchaseProductService;

@Service
public class PurchaseProductServiceImp implements PurchaseProductService {

	@Autowired
	private PurchaseProductRepo purchaseProductRepo;

	@Autowired
	private StoreRepo storeRepo;

	@Override
	public void insertPurchaseProducts(List<PurchaseProduct> purchaseProductList) {
		for (PurchaseProduct purchaseProduct : purchaseProductList) {

			purchaseProductRepo.insertPurchaseProduct(purchaseProduct.getPurchaseProductName(),
					purchaseProduct.getPurchaseProductQuantity(), purchaseProduct.getStore().getStoreId());


			storeRepo.decreaseProductQuantity(purchaseProduct.getStore().getStoreId(),
					purchaseProduct.getPurchaseProductQuantity());
		}
	}

	@Override
	public List<PurchaseProduct> getAllPurchaseProducts() {
		return purchaseProductRepo.findAllPurchaseProducts();
	}

	@Override
	public void updatePurchaseAndStoreProduct(int purchaseId, String purchaseProductName,
											  int storeId, long quantity, String operation) {

		PurchaseProduct currentProduct = purchaseProductRepo.findById(purchaseId)
				.orElseThrow(() -> new RuntimeException("Purchase product not found with ID: " + purchaseId));

		long newPurchaseProductQuantity;

		if (operation.equalsIgnoreCase("increase")) {

			newPurchaseProductQuantity = currentProduct.getPurchaseProductQuantity() + quantity;
			purchaseProductRepo.updatePurchaseProduct(purchaseId, purchaseProductName, newPurchaseProductQuantity);

			storeRepo.updateProductQuantity(storeId, quantity, "decrease");
		} else if (operation.equalsIgnoreCase("decrease")) {

			newPurchaseProductQuantity = currentProduct.getPurchaseProductQuantity() - quantity;
			if (newPurchaseProductQuantity < 0) {
				throw new RuntimeException("Cannot decrease purchase product quantity below zero.");
			}
			purchaseProductRepo.updatePurchaseProduct(purchaseId, purchaseProductName, newPurchaseProductQuantity);

			storeRepo.updateProductQuantity(storeId, quantity, "increase");
		} else {
			throw new IllegalArgumentException("Invalid operation: " + operation);
		}
	}

	@Override
	public Optional<PurchaseProduct> getSingleData(int purchaseId) {
		return purchaseProductRepo.findById(purchaseId);
	}


}
