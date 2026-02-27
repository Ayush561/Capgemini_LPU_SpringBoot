package com.capgemini.Assignment2_26thfeb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.Assignment2_26thfeb.dto.Product;

public interface ProductJpaRepository extends JpaRepository<Product, Integer>{
	List<Product> findByProductName(String productName);
	List<Product> findByCategory_CategoryId(int categoryId);
}
