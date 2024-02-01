package com.davr7.springcrud.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	ResourceNotFoundException(Long id){
		super("Resource not found with id: "+ id);
	}
}
