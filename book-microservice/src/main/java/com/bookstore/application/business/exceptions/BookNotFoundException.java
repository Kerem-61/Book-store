package com.bookstore.application.business.exceptions;

@SuppressWarnings("serial")
public class BookNotFoundException extends RuntimeException {
	
	public BookNotFoundException() {
		super("Book is not found");
	}
}
