package com.capgemini.springbootbasic;

public class Car {
	String brand;
	double price;
	Engine e;
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
	public Engine getE() {
		return e;
	}
	public void setE(Engine e) {
		this.e = e;
	}
	public Car(String brand, double price, Engine e) {
		super();
		this.brand = brand;
		this.price = price;
		this.e = e;
	}
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + ", e=" + e + "]";
	}
	

}
