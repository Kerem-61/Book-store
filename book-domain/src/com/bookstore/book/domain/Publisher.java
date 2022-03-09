package com.bookstore.book.domain;

public final class Publisher {

	private final String name;

	public Publisher(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Publisher [name=" + name + "]";
	}
	
	
	
}
