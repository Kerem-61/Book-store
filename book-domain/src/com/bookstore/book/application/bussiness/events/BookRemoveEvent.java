package com.bookstore.book.application.bussiness.events;

import com.bookstore.book.domain.Book;

public class BookRemoveEvent extends BookEvent {
	private final Book book;

	public BookRemoveEvent(Book book) {
		this.book = book;
	}

	public Book getBook() {
		return book;
	}
}
