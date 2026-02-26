package com.capgemini.springbootbasic;

public class Engine {
	String fuelType;
	double cc;
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public double getCc() {
		return cc;
	}
	public void setCc(double cc) {
		this.cc = cc;
	}
	public Engine(String fuelType, double cc) {
		super();
		this.fuelType = fuelType;
		this.cc = cc;
	}
	@Override
	public String toString() {
		return "Engine [fuelType=" + fuelType + ", cc=" + cc + "]";
	}
	

}
