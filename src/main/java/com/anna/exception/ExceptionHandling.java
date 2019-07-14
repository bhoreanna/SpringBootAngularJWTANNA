package com.anna.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExceptionHandling extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public ExceptionHandling() {
		
	}
	public ExceptionHandling(String exception) {
		super(exception);
		this.errorMessage = exception;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
