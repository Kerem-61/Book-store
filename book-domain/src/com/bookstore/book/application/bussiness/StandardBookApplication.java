package com.bookstore.book.application.bussiness;

import java.util.Optional;

import com.bookstore.book.application.BookApplication;
import com.bookstore.book.application.bussiness.events.BookRemoveEvent;
import com.bookstore.book.application.bussiness.events.BookSavedEvent;
import com.bookstore.book.application.bussiness.exceptions.BookNotFoundException;
import com.bookstore.book.application.bussiness.exceptions.ExistingBookException;
import com.bookstore.book.domain.Book;
import com.bookstore.book.domain.Isbn;
import com.bookstore.book.domain.Title;
import com.bookstore.book.infrastruct.EventPublisher;
import com.bookstore.book.repository.BookRepository;

public class StandardBookApplication implements BookApplication {

	private BookRepository bookRepository;
	private EventPublisher eventPublisher;

	public StandardBookApplication(BookRepository bookRepository, EventPublisher eventPublisher) {
		this.bookRepository = bookRepository;
		this.eventPublisher = eventPublisher;
	}

	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public void setEventPublisher(EventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	@Override
	public Book remove(Isbn isbn) {
		Optional<Book> removedBook = bookRepository.remove(isbn);
		var book = removedBook.orElseThrow(() -> new BookNotFoundException("Book does not exist", isbn.getValue()));
		eventPublisher.PublishEvent(new BookRemoveEvent(book));
		return book;
	}

	@Override
	public Optional<Book> findOneByIsbn(Isbn isbn) {
		return bookRepository.findBookByIsbn(isbn);
	}

	@Override
	public Optional<Book> findOneByName(Title title) {
		return bookRepository.findBookByTitle(title);
	}

	

	@Override
	public Book save(Book book) {
		var isbn = book.getIsbn();
		if (bookRepository.existByIsbn(isbn))
			throw new ExistingBookException("Book already exist", isbn.getValue());
		Book savedBook = bookRepository.save(book);
		var businessEvent = new BookSavedEvent(savedBook);
		eventPublisher.PublishEvent(businessEvent);
		return savedBook;
	}

	

}
