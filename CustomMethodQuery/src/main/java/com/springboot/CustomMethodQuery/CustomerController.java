package com.springboot.CustomMethodQuery;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerJPARespository jpa ;
	
	@PostMapping("/create-customer")
	public Customer saveCustomer(@RequestBody Customer c) {
		return jpa.save(c);
	}
	
	@GetMapping("/get-all")
	public List<Customer> allCustomer() {
		List<Customer> list=jpa.findAll();
		return list;
	}
	
	@GetMapping("/find-customer/{id}")
	public Customer findById(@PathVariable int id) {
		Optional<Customer> option=jpa.findById(id);
		if(option.isPresent()) {
			Customer c = option.get();
			return c;
		}
		else {
			return null;
		}
	}
	
	
	//Updating age of existing customer
	@PatchMapping("/update-customer/{id}")
	public void updateById(@PathVariable int id,@RequestBody  Customer c) {
		Optional<Customer> option=jpa.findById(id);
		if(option.isPresent()) {
			Customer customer = option.get();
			if(c.getAge()!=0) {
				customer.setAge(c.getAge());
			}
			System.out.println("Age updated");
		}
		else {
			System.out.println("Customer not found");
		}
		
	}
	
	//Delete Customer
	@DeleteExchange("/delete-customer/{id}")
	public void deleteById(@PathVariable int id) {
		Optional<Customer> option=jpa.findById(id);
		if(option.isPresent()) {
			Customer c = option.get();
			jpa.delete(c);
			System.out.println("Customer Deleted");
		}
		else {
			System.out.println("Customer not found");
		}
		
	}
	
	//Find Customer by email
	@GetMapping("/findByEmail/{email}")
	public List<Customer> findByEmail(@PathVariable String email) {
		return jpa.findByEmail(email);
	}
	
	//Find customer by name and email
	@GetMapping("/findByNameAndEmail/{name}/{email}")
	public List<Customer> findByNameAndEmail(@PathVariable String name,@PathVariable String email){
		return (List<Customer>) jpa.findByNameOrEmail(name, email);
	}
	
	
	//Find customer by name or email
	@GetMapping("/findByNameOrEmail/{name}/{email}")
	public List<Customer> findByNameOrEmail(@PathVariable String name,@PathVariable String email){
		return (List<Customer>) jpa.findByNameOrEmail(name, email);
	}
	
	
	
	

}
