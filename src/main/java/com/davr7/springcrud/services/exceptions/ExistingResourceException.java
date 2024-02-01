package com.davr7.springcrud.services.exceptions;

public class ExistingResourceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExistingResourceException(String email) {
		super("Existing Resource with email: "+email);
	}
}
