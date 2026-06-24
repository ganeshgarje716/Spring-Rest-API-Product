package com.ganesh.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppException {
	
	@ExceptionHandler(value = Exception.class)
	public String handalException(Exception e) {
		
		return e.getMessage();
	}

}
