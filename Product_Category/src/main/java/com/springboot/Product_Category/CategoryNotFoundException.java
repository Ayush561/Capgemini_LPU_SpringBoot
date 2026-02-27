package com.springboot.Product_Category;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String msg) {
        super(msg);
    }
}