package com.bookstore.adapter;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.bookstore.book.domain.Book;
import com.bookstore.book.domain.Isbn;
import com.bookstore.book.domain.Title;
import com.bookstore.book.repository.BookRepository;
import com.bookstore.document.BookDocument;
import com.bookstore.repository.BookDocumentRepository;

@Repository
public class BookRepositoryMongoAdaptor implements BookRepository{
	private BookDocumentRepository mongoRepo;
	private ModelMapper mapper;
	
	public BookRepositoryMongoAdaptor(BookDocumentRepository mongoRepo, ModelMapper mapper) {
		this.mongoRepo = mongoRepo;
		this.mapper = mapper;
	}

	

	@Override
	public Optional<Book> findBookByTitle(Title title) {
		return mongoRepo.findBookByTitle(title.getValue())
		        .map(doc -> mapper.map(doc, Book.class));
	}

	@Override
	public Optional<Book> findBookByIsbn(Isbn isbn) {
		return mongoRepo.findById(isbn.getValue())
		        .map(doc -> mapper.map(doc, Book.class));
	}

	@Override
	public Optional<Book> remove(Isbn isbn) {
		var document = mongoRepo.findById(isbn.getValue());
		document.ifPresent( mongoRepo::delete);
		return document.map(doc -> mapper.map(doc, Book.class));
	}

	@Override
	public Book save(Book book) {
		var document = mapper.map(book, BookDocument.class);
		return mapper.map(mongoRepo.save(document), Book.class);
	}

	@Override
	public boolean existByIsbn(Isbn isbn) {
		
		return mongoRepo.existsById(isbn.getValue());
	}

}
