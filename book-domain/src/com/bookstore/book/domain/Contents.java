package com.bookstore.book.domain;

import java.util.Objects;

public final class Contents {
	private final String text;

	public Contents(String text) {
		this.text = text;
	}

	public String getValue() {
		return text;
	}

	public static Contents of(String text) {
		Objects.requireNonNull(text);
		if (text.length() < 11)
			throw new IllegalArgumentException("Contents should have at least ten characters");
		return new Contents(text);
	}

	@Override
	public String toString() {
		return "Contents [value=" + text + "]";
	}

}
