package com.storeproject.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.storeproject.entity.Store;
import com.storeproject.repo.StoreRepo;
import com.storeproject.service.StoreService;

@Component
public class StoreServiceImp implements StoreService{

	@Autowired
	private  StoreRepo storeRepo;

	@Override
	public List<Store> getStore() {
		List<Store> store = storeRepo.getStore();
		return store;
	}


	@Override
	public void insertBatchData(List<Store> storeList) {
		for (Store store : storeList) {
			storeRepo.insertData(store.getProductName(), store.getProductQuantity());
		}
	}


}
