package com.bookstore.book.domain;

import java.util.Objects;



public final class Title {
	private final String name;
	
	
	public Title(String value) {
		this.name = value;
	}
	

	public String getValue() {
		return name;
	}



	public static Title of(String name) {
		Objects.requireNonNull(name);
		if (name.length() < 1)
			throw new IllegalArgumentException("Title should have at least two characters");
		return new Title(name);
	}


	@Override
	public String toString() {
		return "Title [name=" + name + "]";
	}

}
