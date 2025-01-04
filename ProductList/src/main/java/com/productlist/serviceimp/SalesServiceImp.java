package com.productlist.serviceimp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.productlist.dto.SalesDTO;
import com.productlist.entity.Products;
import com.productlist.entity.Sales;
import com.productlist.entity.SalesItem;
import com.productlist.repo.ProductsRepo;
import com.productlist.repo.SalesRepo;
import com.productlist.service.SalesService;

@Component
public class SalesServiceImp implements SalesService{

	@Autowired
	SalesRepo salesRepo;
	
	@Autowired
	ProductsRepo productsRepo;
	
	@Override
	public void createSales(SalesDTO salesDTO) {
		
		Sales sales =new Sales();
		
		Sales saveSales = salesRepo.save(sales);
		
		List<SalesItem>  salesItems= salesDTO.getProductDTO().stream().map( salesItemDTO ->{
			Products products=productsRepo.findById(salesItemDTO.getProductId())
			.orElseThrow(()-> new RuntimeException("Sales is not Found"));
			
			if (products.getQuantity()< salesItemDTO.getQuantity()) {
				throw new RuntimeException("Insufficient stock for product:" + products.getProductId());		
			}
			
			SalesItem salesItem =new SalesItem();
			
			salesItem.setProducts(products);
			salesItem.setQuantity(salesItemDTO.getQuantity());
			salesItem.setSales(saveSales);
			
			products.setQuantity(products.getQuantity() - salesItemDTO.getQuantity());
			productsRepo.save(products);
			
			return salesItem;
		}).collect(Collectors.toList());
		
		saveSales.setSalesItems(salesItems);
		
		salesRepo.save(saveSales);
	}

	 @Override
	    public List<SalesDTO> findAllSales() {
	        List<Sales> findAll = salesRepo.findAll();
	        return findAll.stream().map(this::convertToDto).collect(Collectors.toList());
	    }
	    private SalesDTO convertToDto(Sales sales) {
	    	
	        SalesDTO salesDTO = new SalesDTO();
	        
	        salesDTO.setSalesId(sales.getSalesId());
	        salesDTO.setProductDTO(
	            sales.getSalesItems().stream().map(salesItem -> {
	            	
	                SalesDTO.ProductDTO productDTO = new SalesDTO.ProductDTO();
	                productDTO.setProductId(salesItem.getProducts().getProductId());
	                productDTO.setProductName(salesItem.getProducts().getProductName());
	                productDTO.setQuantity(salesItem.getQuantity()); // Use quantity from SalesItem
	                return productDTO;
	            }).collect(Collectors.toList())
	        );

	        return salesDTO;
	    }

}
