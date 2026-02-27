package com.capgemini.Assignment2_26thfeb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.Assignment2_26thfeb.dto.Category;

public interface CategoryJpaRepository extends JpaRepository<Category, Integer>{
	
}
