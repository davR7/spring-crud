package com.davr7.springcrud.resources.exceptions;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class ErrorResponse2 {
	private Instant timestamp;
	private Integer statusCode;
	private String error;
	private Map<String, String> details = new HashMap<>();
	private String path;
	
	public ErrorResponse2(Instant timestamp, Integer statusCode, String error, String path) {
		this.timestamp = timestamp;
		this.statusCode = statusCode;
		this.error = error;
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

	public Map<String, String> getDetails() {
		return details;
	}

	public String getPath() {
		return path;
	}
}
