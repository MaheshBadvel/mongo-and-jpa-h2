package com.h2jpa.spring.exception;

public class ErrorDetails {
	private int value;
	private String message;
	private String details;
	
	public ErrorDetails(int value, String message, String details) {
		super();
		this.value = value;
		this.message = message;
		this.details = details;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	



}
