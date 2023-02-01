package com.keyo.exception;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class APIResponse {
	
	private String message;
	private boolean success;
	private HttpStatus status;
	
	public APIResponse() {
		
	}
	
	public APIResponse(String message, boolean success, HttpStatus status) {
		super();
		this.message = message;
		this.success = success;
		this.status = status;
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	
	
	

}
