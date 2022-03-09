package com.bookstore.book.domain;

import java.util.Objects;

public final class Author {
	private final String first; 
	private final String last;
	

	private Author(String first, String last) {
		this.first = first;
		this.last = last;
	}
	
	

	public String getFirst() {
		return first;
	}



	public String getLast() {
		return last;
	}



	public static Author of(String first, String last) {
		Objects.requireNonNull(first);
		Objects.requireNonNull(last);
		if (first.length() < 2 || last.length() < 2)
			throw new IllegalArgumentException("Fullname should have at least two characters");
		return new Author(first, last);
	}



	@Override
	public String toString() {
		return "Author [first=" + first + ", last=" + last + "]";
	}

	
}
