package com.bookstore.domain;

import java.util.Objects;

public class Book {
	
	private final String isbn;

	public Book(String isbn) {
		this.isbn = isbn;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public static Book of(String isbn) {
		if (!isValid(isbn))
			throw new IllegalArgumentException("This is not a valid isbn");
		return new Book(isbn);
	}

	private static boolean isValid(String isbn) {
		var isbnNumber = isbn.toCharArray();
		var sum = 0;
		if (isbnNumber.length == 10) {
			for (var i = 0; i < 10; i++) {
				sum += i * isbnNumber[i];
			}
			if (isbnNumber[9] == sum % 11)
				return true;
		} else if (isbnNumber.length == 13) {
			for (var i = 0; i < 12; i++) {
				if (i % 2 == 0) {
					sum += isbnNumber[i];
				} else {
					sum += isbnNumber[i] * 3;
				}
			}

			if (isbnNumber[12] == 10 - (sum % 10))
				return true;
		}

		return false;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(isbn, other.isbn);
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + "]";
	}
	
}
