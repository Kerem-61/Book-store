package com.bookstore.customer.domain;



public final class Email {
	private final String value;
	private Email(String value) {
		
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	public static Email of(String value) {
		return new Email(value);
	}

	@Override
	public String toString() {
		return "Email [value=" + value + "]";
	}
	
}
