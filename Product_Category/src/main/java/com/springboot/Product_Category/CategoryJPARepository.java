package com.springboot.Product_Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJPARepository extends JpaRepository<Category, Integer> {
	
}