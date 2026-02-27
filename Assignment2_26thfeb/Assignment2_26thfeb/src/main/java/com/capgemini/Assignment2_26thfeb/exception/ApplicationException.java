package com.capgemini.Assignment2_26thfeb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class ApplicationException {
	//acts as a catch block to handle exception
	
		@ExceptionHandler(DataNotExist.class)
		public String handleException1() {
			return "Data Not Exist";
		}
	
		@ExceptionHandler(CategoryNotFoundException.class)
		public ResponseEntity<String> handleException(CategoryNotFoundException ex){
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
		}

		//If none exception will work then this will work.
		@ExceptionHandler(Exception.class)
		public String handleException() {
			return "Exception Handle Method";
		}
		
	


}

