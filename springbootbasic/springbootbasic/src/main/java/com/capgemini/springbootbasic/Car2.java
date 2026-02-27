package com.capgemini.springbootbasic;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Car2 {
	@Id
	int id;
	String brand;
	double price;
	
	public Car2(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Car2(int id, String brand, double price) {
		this.id = id;
		this.brand = brand;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car2 [id=" + id + ", brand=" + brand + ", price=" + price + "]";
	}
	
	
	

}
