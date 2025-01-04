package com.storeproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "purchase_product")
public class PurchaseProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int purchaseId;

	@Column(name = "purchase_product_name")
	private String purchaseProductName;

	@Column(name = "purchase_product_quantity")
	private long purchaseProductQuantity;

	@ManyToOne
	@JoinColumn(name = "store_id", referencedColumnName = "storeId")
	private Store store;

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getPurchaseProductName() {
		return purchaseProductName;
	}

	public void setPurchaseProductName(String purchaseProductName) {
		this.purchaseProductName = purchaseProductName;
	}

	public long getPurchaseProductQuantity() {
		return purchaseProductQuantity;
	}

	public void setPurchaseProductQuantity(long purchaseProductQuantity) {
		this.purchaseProductQuantity = purchaseProductQuantity;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}



}

