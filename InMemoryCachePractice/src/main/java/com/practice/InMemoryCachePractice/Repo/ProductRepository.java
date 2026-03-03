package com.practice.InMemoryCachePractice.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.InMemoryCachePractice.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	//ABOVE SPRINGBOOTAPPLICATION WE WILL USE @EnanbleCaching

}
