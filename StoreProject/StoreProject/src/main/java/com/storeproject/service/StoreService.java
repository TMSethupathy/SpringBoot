package com.storeproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.storeproject.entity.Store;

@Service
public interface StoreService {

	void insertBatchData(List<Store> storeList);

	List<Store> getStore();
}
