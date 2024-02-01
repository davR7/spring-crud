package com.davr7.springcrud.resources.exceptions;

import java.time.Instant;

public class ErrorResponse {
	private Instant timestamp;
	private Integer statusCode;
	private String error;
	private String message;
	private String path;
	
	public ErrorResponse(Instant timestamp, Integer statusCode, String error, String message, String path) {
		this.timestamp = timestamp;
		this.statusCode = statusCode;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public String getError() {
		return error;
	}

	public String getMessage() {
		return message;
	}

	public String getPath() {
		return path;
	}
}
