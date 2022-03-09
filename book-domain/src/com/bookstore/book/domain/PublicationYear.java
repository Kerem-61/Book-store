package com.bookstore.book.domain;

public final class PublicationYear {
	
	private final int value;

	public PublicationYear(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "PublicationYear [value=" + value + "]";
	}
	
	
	

}
