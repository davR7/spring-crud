package com.davr7.springcrud.resources.exceptions;


import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.davr7.springcrud.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handlerResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest req) {
		Integer status = HttpStatus.NOT_FOUND.value();
		String error = "Resource Not Found";
		
		ErrorResponse errResponse = new ErrorResponse(Instant.now(), status, error, e.getMessage() , req.getRequestURI());
		return ResponseEntity.status(status).body(errResponse);
	}
}
