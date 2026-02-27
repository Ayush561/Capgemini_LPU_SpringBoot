package com.springboot.Product_Category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJPARepository extends JpaRepository<Product, Integer> {

    List<Product> findByProductName(String productName);

    List<Product> findByCategoryCategoryId(int categoryId);
}