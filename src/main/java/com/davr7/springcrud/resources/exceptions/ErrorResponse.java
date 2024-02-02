package com.davr7.springcrud.resources.exceptions;

import java.time.Instant;

public class ErrorResponse extends StandardError {
	private String message;

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(Instant timestamp, String path, Integer statusCode, String error, String message) {
		super(timestamp, path, statusCode, error);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
