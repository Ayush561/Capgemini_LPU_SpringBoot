package com.capgemini.springbootbasic;

//@Component
public class Cricketer {
	private String name;
	private String role;
	private int runs;
	private int no_of_match;
	private double average;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getNo_of_match() {
		return no_of_match;
	}
	public void setNo_of_match(int no_of_match) {
		this.no_of_match = no_of_match;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public Cricketer(String name, String role, int runs, int no_of_match, double average) {
		this.name = name;
		this.role = role;
		this.runs = runs;
		this.no_of_match = no_of_match;
		this.average = average;
	}
	@Override
	public String toString() {
		return "Cricketer [name=" + name + ", role=" + role + ", runs=" + runs + ", no_of_match=" + no_of_match
				+ ", average=" + average + "]";
	}

}
