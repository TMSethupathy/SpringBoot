package com.productlist.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.productlist.dto.PurchasesDTO;




@Service
public interface PurchasesService {
	
	//post
	void createPurchases(PurchasesDTO purchasesDto);
	
	//get
	List<PurchasesDTO> getAllPurchases();
	
	//put 
	void editPurchase(int purchaseId,PurchasesDTO purchasesDto );


}
