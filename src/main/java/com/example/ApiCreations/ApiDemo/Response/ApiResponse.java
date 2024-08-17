package com.example.ApiCreations.ApiDemo.Response;

public class ApiResponse {
	 private String message;

	public ApiResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return " [message=" + message + "]";
	}
	 
}
