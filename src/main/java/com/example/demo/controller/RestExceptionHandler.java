package com.example.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.exception.DuplicateException;
import com.example.demo.exception.ErrorResponse;
import com.example.demo.exception.ResourceNotFoundException;

@ControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(DuplicateException.class)
	public final ResponseEntity<ErrorResponse> exceptionDuplicateHnadler(Exception ex){
		ErrorResponse error = new ErrorResponse();
		error.setCode(HttpStatus.CONFLICT.value());
		error.setMessage(((DuplicateException) ex).getMessage());
		
		return new ResponseEntity<ErrorResponse>(error,new HttpHeaders(), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ErrorResponse> exceptionResourceNotFoundHnadler(Exception ex){
		ErrorResponse error = new ErrorResponse();
		error.setCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(((ResourceNotFoundException) ex).getMessage());
		
		return new ResponseEntity<ErrorResponse>(error,new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
}
