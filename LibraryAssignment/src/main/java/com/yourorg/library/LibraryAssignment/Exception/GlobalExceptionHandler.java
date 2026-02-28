package com.yourorg.library.LibraryAssignment.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleNotFound(ResourceNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(InvalidOperationException.class)
    public String handleInvalidOperation(InvalidOperationException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(Exception.class)
    public String handleAll(Exception ex) {
        return "Something went wrong: " + ex.getMessage();
    }
}