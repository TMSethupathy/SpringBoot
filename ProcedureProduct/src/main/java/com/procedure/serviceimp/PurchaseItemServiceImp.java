package com.procedure.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.procedure.model.PurchaseItem;
import com.procedure.repo.PurchaseItemRepo;
import com.procedure.service.PurchaseItemService;

@Component
public class PurchaseItemServiceImp implements PurchaseItemService {

	@Autowired
	PurchaseItemRepo purchaseItemRepo;

	@Override
	public List<PurchaseItem> findAllPurchase() {	
		return purchaseItemRepo.findAll();
	}
}
