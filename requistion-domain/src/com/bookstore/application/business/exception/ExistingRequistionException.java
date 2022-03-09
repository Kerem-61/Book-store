package com.bookstore.application.business.exception;

@SuppressWarnings("serial")
public class ExistingRequistionException extends RuntimeException {
	private final String isbn;

	public ExistingRequistionException(String message, String isbn) {
		super(message);
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}
		
		
}
