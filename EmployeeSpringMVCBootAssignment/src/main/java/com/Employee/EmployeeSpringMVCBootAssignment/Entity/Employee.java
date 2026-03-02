package com.Employee.EmployeeSpringMVCBootAssignment.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	private String name;
	private double salary;
	private String role;
	
	@Id
	private  String email;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Employee(String name, double salary, String role, String email, String password) {
		this.name = name;
		this.salary = salary;
		this.role = role;
		this.email = email;
		this.password = password;
	}
	
	public Employee() {
		
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", role=" + role + ", email=" + email + ", password="
				+ password + "]";
	}
	
	
	

}
