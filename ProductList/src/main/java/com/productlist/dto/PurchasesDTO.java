package com.productlist.dto;

import java.util.List;

public class PurchasesDTO {

	private int purchaseId;
    private List<ProductDTO> productDTO;
    
	 public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	public List<ProductDTO> getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(List<ProductDTO> productDTO) {
		this.productDTO = productDTO;
	}


	public static class ProductDTO {
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
   
