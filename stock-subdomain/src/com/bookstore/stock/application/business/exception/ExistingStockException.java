package com.bookstore.stock.application.business.exception;

@SuppressWarnings("serial")
public class ExistingStockException extends RuntimeException {

	private final String sku;

	public String getSku() {
		return sku;
	}

	public ExistingStockException(String message, String sku) {
		super(message);
		this.sku = sku;

	}
}
