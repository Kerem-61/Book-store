package com.bookstore.application.business.exceptions;

@SuppressWarnings("serial")
public class BookAlreadyExistException extends RuntimeException {
	public BookAlreadyExistException() {
		super("Book already exist");
	}
}
