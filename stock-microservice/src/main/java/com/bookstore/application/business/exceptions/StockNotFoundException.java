package com.bookstore.application.business.exceptions;

@SuppressWarnings("serial")
public class StockNotFoundException extends RuntimeException {
	public StockNotFoundException() {
		super("Stock is not found");
	}
}
