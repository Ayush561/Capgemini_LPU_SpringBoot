package com.springboot.CustomMethodQuery;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {
	@Id
	private int id;
	private int phone;
	private String email;
	private String name;
	private int age;
	private char gender;
	private String dob;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public Customer(int id, int phone, String email, String name, int age, char gender, String dob) {
		super();
		this.id = id;
		this.phone = phone;
		this.email = email;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.dob = dob;
	}
	
	public Customer() {
		
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", phone=" + phone + ", email=" + email + ", name=" + name + ", age=" + age
				+ ", gender=" + gender + ", dob=" + dob + "]";
	}
	
	
	
	

}
