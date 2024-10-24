package com.procedure.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.procedure.model.Purchases;
import com.procedure.repo.PurchasesRepo;
import com.procedure.service.PurchasesService;

@Component
public class PurchasesServiceImp implements PurchasesService{
	
	@Autowired
	PurchasesRepo purchasesRepo;

	@Override
	public List<Purchases> findAllPurchase() {
		return purchasesRepo.findAll();
	}

}
