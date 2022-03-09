package com.bookstore.customer.domain;

import java.util.Objects;


public final class StrongPassword {
	private final String value;

	
	
	private StrongPassword(String value) {
	
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	public static StrongPassword of(String value) {
		Objects.requireNonNull(value);
		
		if(value.length()<5)
			throw new IllegalArgumentException("STRONG_Password should at least 5 character");
		
		return new StrongPassword(value);
	}
	@Override
	public String toString() {
		return "Password [value=" + value + "]";
	}
	
	
}
