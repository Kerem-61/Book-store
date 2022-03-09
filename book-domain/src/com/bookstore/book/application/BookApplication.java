package com.bookstore.book.application;

import java.util.Optional;

import com.bookstore.book.domain.Book;
import com.bookstore.book.domain.Isbn;
import com.bookstore.book.domain.Title;

public interface BookApplication {

	Optional<Book> findOneByIsbn(Isbn isbn);

	Book save(Book book);

	Book remove(Isbn isbn);

	Optional<Book> findOneByName(Title title);

	
	

}
