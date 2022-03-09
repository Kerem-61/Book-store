package com.bookstore.application.business.exceptions;

@SuppressWarnings("serial")
public class StockAlreadyExistException extends RuntimeException {
	public StockAlreadyExistException() {
		super("Stock already exist");
	}
}
