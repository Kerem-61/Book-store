package com.bookstore.book.domain;

import java.util.Objects;



public final class Price {
	private final double price;
	private final FiatCurrency currency;


	public Price(double price, FiatCurrency currency) {
		this.price = price;
		this.currency = currency;
	}
	
	public static Price of(double price, FiatCurrency currency) {
		Objects.requireNonNull(currency, "Currency cannot be null.");
		if (price <= 0.0)
			throw new IllegalArgumentException("Price value cannot be zero or negative");
		return new Price(price, currency);
	}


	public FiatCurrency getCurrency() {
		return currency;
	}


	public double getPrice() {
		return price;
	}
	
	
	

}
