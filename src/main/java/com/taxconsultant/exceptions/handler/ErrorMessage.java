package com.taxconsultant.exceptions.handler;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
	
	private HttpStatus status;
	private String errorMessage;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	public ErrorMessage(HttpStatus status, String errorMessage) {
		super();
		this.status = status;
		this.errorMessage = errorMessage;
	}
	
	

}
