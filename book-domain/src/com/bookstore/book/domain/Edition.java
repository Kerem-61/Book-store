package com.bookstore.book.domain;

public final class Edition {
	private final String value;

	public Edition(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Edition [value=" + value + "]";
	}
}
