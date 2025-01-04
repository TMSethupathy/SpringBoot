package com.productlist.dto;

import java.util.List;

public class SalesDTO {
	
	private int salesId;
	private List<ProductDTO> productDTO;
	
	public int getSalesId() {
		return salesId;
	}
	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}
	public List<ProductDTO> getProductDTO() {
		return productDTO;
	}
	public void setProductDTO(List<ProductDTO> productDTO) {
		this.productDTO = productDTO;
	}
	
	public static class ProductDTO{
		
		 private int productId;
		 private String productName;
	     private long quantity;
	     
		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public long getQuantity() {
			return quantity;
		}
		public void setQuantity(long quantity) {
			this.quantity = quantity;
		}
		
	}
}
