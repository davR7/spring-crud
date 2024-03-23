package com.davr7.springcrud.common;

import java.time.Instant;

public class StandardError {
	protected Instant timestamp;
	protected String path;
	protected Integer statusCode;
	protected String error;
	
	public StandardError() {
	}

	public StandardError(Instant timestamp, String path, Integer statusCode, String error) {
		this.timestamp = timestamp;
		this.path = path;
		this.statusCode = statusCode;
		this.error = error;	
	}

	public Instant getTimestamp() {
		return timestamp;
	}
	
	public String getPath() {
		return path;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public String getError() {
		return error;
	}
}
