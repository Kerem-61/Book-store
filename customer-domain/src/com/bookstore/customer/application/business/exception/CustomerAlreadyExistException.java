package com.bookstore.customer.application.business.exception;
@SuppressWarnings("serial")
public class CustomerAlreadyExistException extends RuntimeException {
	
	private final String identity;

	public CustomerAlreadyExistException(String message, String identity) {
		super(message);
		this.identity=identity;
		
		
	}

	public String getIdentity() {
		return identity;
	}
	

}
