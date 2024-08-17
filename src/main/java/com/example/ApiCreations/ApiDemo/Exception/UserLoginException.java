package com.example.ApiCreations.ApiDemo.Exception;

import org.springframework.http.HttpStatus;

public class UserLoginException {
	private final String message;
//	private final Throwable throwable;
	private final HttpStatus httpStatus;
	public UserLoginException(String message, HttpStatus httpStatus) {
		super();
		this.message = message;
	
		this.httpStatus = httpStatus;
	}
	public String getMessage() {
		return message;
	}
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	
}
