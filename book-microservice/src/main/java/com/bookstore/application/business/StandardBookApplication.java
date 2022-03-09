package com.bookstore.application.business;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bookstore.application.BookApplication;
import com.bookstore.application.business.exceptions.BookAlreadyExistException;
import com.bookstore.application.business.exceptions.BookNotFoundException;
import com.bookstore.application.events.BookAddedEvent;
import com.bookstore.application.events.RemoveBookEvent;
import com.bookstore.document.BookDocument;
import com.bookstore.dto.request.AddBookRequest;
import com.bookstore.dto.request.UpdateBookRequest;
import com.bookstore.dto.response.AddBookResponse;
import com.bookstore.dto.response.BookResponse;
import com.bookstore.dto.response.RemoveBookResponse;
import com.bookstore.repository.BookMongoRepository;

@Service
public class StandardBookApplication implements BookApplication{

	BookMongoRepository bookMongoRepository;
	private ModelMapper modelMapper;
	private ApplicationEventPublisher eventPublisher;
	
	
	
	public StandardBookApplication(BookMongoRepository bookMongoRepository, ApplicationEventPublisher eventPublisher) {
		this.bookMongoRepository = bookMongoRepository;
		this.eventPublisher = eventPublisher;
	}
	

	public StandardBookApplication(BookMongoRepository bookMongoRepository, ModelMapper modelMapper,
			ApplicationEventPublisher eventPublisher) {
		this.bookMongoRepository = bookMongoRepository;
		this.modelMapper = modelMapper;
		this.eventPublisher = eventPublisher;
	}


	@Override
	public BookResponse findBookByIsbn(String isbn) {
		var book = bookMongoRepository.findByIsbn(isbn).orElseThrow(() -> new BookNotFoundException());
		return modelMapper.map(book, BookResponse.class);
	}

	@Override
	public AddBookResponse addBook(AddBookRequest request) {
		var identity = request.getIdentity();
		if( bookMongoRepository.existsById(identity))
			throw new BookAlreadyExistException();
		var book = modelMapper.map(request, BookDocument.class);
		book = bookMongoRepository.insert(book);
		var bookAddedEvent = new BookAddedEvent(modelMapper.map(book,BookResponse.class));
		eventPublisher.publishEvent(bookAddedEvent);
		return modelMapper.map(book, AddBookResponse.class);
	}

	@Override
	public RemoveBookResponse removeBook(String isbn) {
		var book = bookMongoRepository.findByIsbn(isbn).orElseThrow(() -> new BookNotFoundException());
		bookMongoRepository.delete(book);
		var removeBookResponse = modelMapper.map(book, RemoveBookResponse.class);
		var bookRemovedEvent = new RemoveBookEvent(modelMapper.map(book,BookResponse.class));
		eventPublisher.publishEvent(bookRemovedEvent);
		return removeBookResponse;
	}

	@Override
	public List<BookResponse> findBooks(int page, int size) {
		var pageRequest = PageRequest.of(page, size);
		return bookMongoRepository.findAll(pageRequest).stream().map(emp -> modelMapper.map(emp, BookResponse.class))
				.toList();	
	}

	@Override
	public BookResponse updateBook(String identity, UpdateBookRequest request) {
		var book = bookMongoRepository.findById(identity).orElseThrow(() -> new BookNotFoundException());
		modelMapper.map(request, book);
		book.setIdentity(identity);
		return modelMapper.map(bookMongoRepository.save(book), BookResponse.class);
	}


	
	
	



	
	


}
