package com.springboot.Product_Category;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public String handleCategoryNotFound(CategoryNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public String handleProductNotFound(ProductNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(InvalidProductDataException.class)
    public String handleInvalidProduct(InvalidProductDataException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(Exception.class)
    public String handleAll(Exception ex) {
        return "Something went wrong: " + ex.getMessage();
    }
}