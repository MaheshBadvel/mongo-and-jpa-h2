package com.springboot.items.exception;

import java.util.Date;

public class ErrorDetails {
	private Date timestamp;
	private int value;
	private String message;
	private String details;
	
	public ErrorDetails(Date timestamp,int value, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.value = value;
		this.message = message;
		this.details = details;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
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
