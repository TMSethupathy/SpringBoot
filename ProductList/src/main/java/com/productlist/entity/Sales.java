package com.productlist.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Sales")
public class Sales {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int salesId;
	
	@OneToMany(mappedBy = "sales",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<SalesItem> salesItems;

	public int getSalesId() {
		return salesId;
	}

	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}

	public List<SalesItem> getSalesItems() {
		return salesItems;
	}

	public void setSalesItems(List<SalesItem> salesItems) {
		this.salesItems = salesItems;
	}

	
	
	
}
