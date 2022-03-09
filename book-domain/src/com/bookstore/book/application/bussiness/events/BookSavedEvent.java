package com.bookstore.book.application.bussiness.events;

import com.bookstore.book.domain.Book;

public class BookSavedEvent extends BookEvent {

	private final Book book;

	public BookSavedEvent(Book book) {
		this.book = book;
	}

	public Book getBook() {
		return book;
	}

}
