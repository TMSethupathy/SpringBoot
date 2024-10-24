package com.procedure.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.procedure.model.PurchaseItem;

@Service
public interface PurchaseItemService {
	
	List<PurchaseItem> findAllPurchase();

}
