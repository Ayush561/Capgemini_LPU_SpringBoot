package com.springboot.Product_Category;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;



@OpenAPIDefinition(
info = @Info(
title = "Product Service API",
version = "1.0",
description = "API documentation for Product Service"
)
)

@SpringBootApplication
public class ProductCategoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCategoryApplication.class, args);
	}

	@Bean
	public OpenAPI getOpenAPI() {
		return new OpenAPI();
	}
}
