package com.bookstore.application.business.exceptions;

@SuppressWarnings("serial")
public class CustomerNotFoundException extends RuntimeException {


	public CustomerNotFoundException() {
		super("Customer is not found");
		
	}

	
	
}
