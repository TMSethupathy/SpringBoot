package com.productlist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.productlist.dto.SalesDTO;

@Service
public interface SalesService {
	
	void createSales(SalesDTO salesDTO);
	
	List<SalesDTO> findAllSales();

}
