package com.keyo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<APIResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
		
		
		
		String message = ex.getMessage();
		
		//.
		
		//APIResponse apiResponse = new APIResponse();
		//apiResponse.
		return new ResponseEntity<APIResponse>(new APIResponse(message, true, HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
	}

}
