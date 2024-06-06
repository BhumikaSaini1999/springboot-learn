package com.luv2code.demo.rest;

public class StudentErrorResponse {
	private int staus;
	private String message;
	private long timestamp;
	
	public StudentErrorResponse() {
		
	}
	
	public StudentErrorResponse(int staus, String message, long timestamp) {
		super();
		this.staus = staus;
		this.message = message;
		this.timestamp = timestamp;
	}

	public int getStaus() {
		return staus;
	}

	public void setStaus(int staus) {
		this.staus = staus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
}
