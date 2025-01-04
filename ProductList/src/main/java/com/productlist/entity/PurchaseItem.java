package com.productlist.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PurchaseItem")
public class PurchaseItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "purchase_id",
    referencedColumnName = "purchaseId")
    private Purchases purchase;

    @ManyToOne
    @JoinColumn(name = "product_id",
    referencedColumnName = "productId")
    private Products products;

    @Column(name = "quantity")
    private long quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Purchases getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchases purchase) {
		this.purchase = purchase;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	
  
    
}