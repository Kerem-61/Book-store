package com.bookstore.book.repository;

import java.util.Optional;

import com.bookstore.book.domain.Book;
import com.bookstore.book.domain.Isbn;
import com.bookstore.book.domain.Title;

public interface BookRepository {
	
	
	Optional<Book> findBookByTitle(Title title);
	Optional<Book> findBookByIsbn(Isbn isbn);
	Optional<Book> remove(Isbn isbn);
	Book save(Book book);
	boolean existByIsbn(Isbn isbn);
	
	
}
