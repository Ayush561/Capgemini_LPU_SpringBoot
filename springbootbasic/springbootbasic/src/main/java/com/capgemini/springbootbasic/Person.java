package com.capgemini.springbootbasic;

import java.util.List;

public class Person {
	
	private int id;
	private String name;
	List<String> item ;
	public Person(int id, String name, List<String> item) {
		this.id = id;
		this.name = name;
		this.item = item;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", item=" + item + "]";
	}
	
	
	
	

}
