package com.practice.RedisServerForGlobalCache.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.RedisServerForGlobalCache.Entity.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {
	

}