package com.bookstore.book.domain;

public final class Reviews {
	private final int value;

	public Reviews(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Reviews [value=" + value + "]";
	}
	
	
	
}
