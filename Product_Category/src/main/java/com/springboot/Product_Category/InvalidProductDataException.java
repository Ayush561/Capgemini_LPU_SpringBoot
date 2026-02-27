package com.springboot.Product_Category;

public class InvalidProductDataException extends RuntimeException {

    public InvalidProductDataException(String msg) {
        super(msg);
    }
}