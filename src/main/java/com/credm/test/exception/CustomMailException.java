package com.credm.test.exception;

public class CustomMailException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	CustomMailException(String message){
		super(message);
	}

}
