package com.bookstore.application.events;

import java.util.UUID;

import com.bookstore.dto.response.BookResponse;

public class RemoveBookEvent extends BookEvent {

	private final BookResponse book;

	public RemoveBookEvent(BookResponse book) {
		super(UUID.randomUUID().toString());
		this.book = book;
	}

	public BookResponse getBook() {
		return book;
	}
}
