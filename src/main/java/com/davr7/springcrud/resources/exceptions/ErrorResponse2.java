package com.davr7.springcrud.resources.exceptions;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class ErrorResponse2 extends StandardError {
	private Map<String, String> details = new HashMap<>();
	
	public ErrorResponse2() {
		super();
	}

	public ErrorResponse2(Instant timestamp, String path, Integer statusCode, String error) {
		super(timestamp, path, statusCode, error);
	}

	public Map<String, String> getDetails() {
		return details;
	}
}
