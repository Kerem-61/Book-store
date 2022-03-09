package com.bookstore.customer.domain;

public final class Epurse {
	private final double value;

	private Epurse(double value) {
		
		this.value = value;
	}
	public static Epurse of(double value) {
		return new Epurse(value);
	}
	public double getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Epurse [value=" + value + "]";
	}
	
	
}
