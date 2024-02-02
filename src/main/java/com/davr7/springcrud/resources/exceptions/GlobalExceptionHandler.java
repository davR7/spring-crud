package com.davr7.springcrud.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.davr7.springcrud.services.exceptions.ExistingResourceException;
import com.davr7.springcrud.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handlerResourceNotFoundException(ResourceNotFoundException e,
			HttpServletRequest req) {
		Integer status = HttpStatus.NOT_FOUND.value();
		String error = "Resource Not Found";

		ErrorResponse errResponse = new ErrorResponse(Instant.now(), req.getRequestURI(), status, error, e.getMessage());
		return ResponseEntity.status(status).body(errResponse);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handlerExistingResourceException(ExistingResourceException e,
			HttpServletRequest req) {
		Integer status = HttpStatus.BAD_REQUEST.value();
		String error = "Existing Resource";

		ErrorResponse errResponse = new ErrorResponse(Instant.now(), req.getRequestURI(), status, error, e.getMessage());
		return ResponseEntity.status(status).body(errResponse);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse2> handlerValidationExceptions(MethodArgumentNotValidException e, HttpServletRequest req) {
		Integer status = HttpStatus.BAD_REQUEST.value();
		String error = "Validation Failure";
		ErrorResponse2 errResponse = new ErrorResponse2(Instant.now(), req.getRequestURI(), status, error);
		
		e.getBindingResult().getAllErrors().forEach((err) -> {
			String fieldName = ((FieldError) err).getField();
			String errorMessage = err.getDefaultMessage();
			errResponse.getDetails().put(fieldName, errorMessage);
		});
		
		return ResponseEntity.status(status).body(errResponse);
	}
}
