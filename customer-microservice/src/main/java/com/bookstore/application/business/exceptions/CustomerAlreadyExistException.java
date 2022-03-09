package com.bookstore.application.business.exceptions;

@SuppressWarnings("serial")
public class CustomerAlreadyExistException extends RuntimeException {

	public CustomerAlreadyExistException() {
		super("Customer already exist");
		
	}

}
