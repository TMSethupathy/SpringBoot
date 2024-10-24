package com.procedure.model;

public class PurchaseItem  {

	private int id;
	private Purchases purchases;
	private Products products;
	private long quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Purchases getPurchases() {
		return purchases;
	}

	public void setPurchases(Purchases purchases) {
		this.purchases = purchases;
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
