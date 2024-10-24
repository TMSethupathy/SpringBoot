package com.procedure.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.procedure.model.Purchases;

@Service
public interface PurchasesService {
	
	List<Purchases> findAllPurchase();
	

}
