package com.springboot.Product_Category;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String msg) {
        super(msg);
    }
}