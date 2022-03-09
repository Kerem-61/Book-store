package com.bookstore.application.events;

import java.util.UUID;

import com.bookstore.dto.response.BookResponse;


public class BookAddedEvent extends BookEvent {
	private final BookResponse book;

	public BookAddedEvent(BookResponse book) {
		super(UUID.randomUUID().toString());
		this.book = book;
	}

	public BookResponse getBook() {
		return book;
	}
}
