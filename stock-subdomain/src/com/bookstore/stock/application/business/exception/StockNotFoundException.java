package com.bookstore.stock.application.business.exception;

@SuppressWarnings("serial")
public class StockNotFoundException extends RuntimeException {
	private final String sku;

	public String getSku() {
		return sku;
	}

	public StockNotFoundException(String message, String sku) {
		super(message);
		this.sku = sku;

	}

}
