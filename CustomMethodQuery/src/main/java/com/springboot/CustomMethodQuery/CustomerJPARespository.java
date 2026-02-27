package com.springboot.CustomMethodQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface CustomerJPARespository extends JpaRepository<Customer, Integer> {
	
	List<Customer> findByEmail(String email);
	
	List<Customer> findByNameAndEmail(String name,String email);
	
	List<Customer> findByNameOrEmail(String name,String email);
	
	List<Customer> findByIdBetween(int start,int end);
	
	List<Customer> findByAgeGreaterThan(int age);
	
	List<Customer> findByEmailIsNotNull();
	
	
	
	

	
}
