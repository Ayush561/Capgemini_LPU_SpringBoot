package com.capgemini.Assignment2_26thfeb.dto;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	private int productId;
	private String productName;
	private int price;
	
	@ManyToOne
	private Category category;

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product(int productId, String productName, int price, Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.category=category;
		
	}
	
	Product(){
		
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", category="
				+ category + "]";
	}
	
	
	
	

}
