package com.bookstore.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bookstore.book.domain.Book;
import com.bookstore.book.domain.Popularity;
import com.bookstore.document.BookDocument;
import com.bookstore.dto.request.AddBookRequest;
import com.bookstore.dto.response.AddBookResponse;
import com.bookstore.dto.response.BookResponse;
import com.bookstore.dto.response.RemoveBookResponse;


@Configuration
public class ModelMapperConfig {
	private static final Converter<Book, BookResponse>
	    BOOK_TO_BOOK_RESPONSE_CONVERTER = 
	(context) -> {
	   var book = context.getSource();
	   var author = book.getAuthor();
	   var response = new BookResponse();
	   response.setIdentity(book.getIsbn().getValue());
	   response.setTitle(book.getTitle().getValue());
	   response.setAuthor(String.format("%s %s",
			   author.getFirst(), author.getLast()));
	   response.setPublisher(book.getPublisher().getName());
	   response.setEdition(book.getEdition().getValue());
	   response.setPhoto(book.getCoverPhoto().getBase64Values());
	   response.setPublication(book.getPublication().getValue());
	   response.setPrice(book.getPrice().getPrice());
	   response.setReviews(book.getReviews().getValue());
	   response.setContents(book.getContents().getValue());
	   response.setPopularity(book.getPopularity().get(0));
	   response.setCategory(book.getCategory().getId());
	   System.err.println("BOOK_TO_BOOK_RESPONSE_CONVERTER: "+response);
	   return response;
	};
	private static final Converter<Book, RemoveBookResponse>
	BOOK_TO_REMOVE_BOOK_RESPONSE_CONVERTER = 
	(context) -> {
		 var book = context.getSource();
		   var author = book.getAuthor();
		   var response = new RemoveBookResponse();
		   response.setIdentity(book.getIsbn().getValue());
		   response.setTitle(book.getTitle().getValue());
		   response.setAuthor(String.format("%s %s",
				   author.getFirst(), author.getLast()));
		   response.setPublisher(book.getPublisher().getName());
		   response.setEdition(book.getEdition().getValue());
		   response.setPhoto(book.getCoverPhoto().getBase64Values());
		   response.setPublication(book.getPublication().getValue());
		   response.setPrice(book.getPrice().getPrice());
		   response.setPublication(book.getPublication().getValue());
		   response.setPrice(book.getPrice().getPrice());
		   response.setReviews(book.getReviews().getValue());
		   response.setContents(book.getContents().getValue());
		   response.setPopularity(book.getPopularity().get(0));
		   response.setCategory(book.getCategory().getName());
		return response;
	};
	
	private static final Converter<Book, AddBookResponse>
	BOOK_TO_ADD_BOOK_RESPONSE_CONVERTER = 
	(context) -> {
		var book = context.getSource();
		   var author = book.getAuthor();
		   var response = new AddBookResponse();
		   response.setIdentity(book.getIsbn().getValue());
		   response.setTitle(book.getTitle().getValue());
		   response.setAuthor(String.format("%s %s",
				   author.getFirst(), author.getLast()));
		   response.setPublisher(book.getPublisher().getName());
		   response.setEdition(book.getEdition().getValue());
		   response.setPublication(book.getPublication().getValue()); 
		   response.setPhoto(book.getCoverPhoto().getBase64Values());
		   response.setPrice(book.getPrice().getPrice());
		   response.setPublication(book.getPublication().getValue());
		   response.setPrice(book.getPrice().getPrice());
		   response.setReviews(book.getReviews().getValue());
		   response.setContents(book.getContents().getValue());
		   response.setPopularity(book.getPopularity().get(0));
		   response.setCategory(book.getCategory().getName());
		return response;
	};
	
	private static final Converter<AddBookRequest, Book>
	ADD_BOOK_REQUEST_TO_BOOK_CONVERTER = 
	(context) -> {
		var request = context.getSource();
		return new Book.Builder()
				           .isbn(request.getIdentity())
				           .author(request.getFirstName(), request.getLastName())
				           .title(request.getTitle())
				           .publisher(request.getPublisher())
				           .edition(request.getEdition())
				           .photo(request.getPhoto().getBytes())
				           .publication(request.getPublication())
				           .price(request.getPrice(), request.getFiatCurrency())
				           .popularity(request.getPopularity().toString())
				           .category(request.getCategory().toString(), request.getCategory().toString())
				           .contents(request.getContents())
				           .photo(request.getPhoto().getBytes())
				           .reviews(request.getReviews())
				           .popularity(request.getPopularity().toString())
				           .build();
	};
	
	private static final Converter<BookDocument, Book>
	BOOK_DOCUMENT_TO_BOOK_CONVERTER = 
			(context) -> {
				var document = context.getSource();
				var names = document.getAuthor().split(" ");
				return new Book.Builder()
				   .author(names[0], names[1])
				   .isbn(document.getIdentity())
				   .title(document.getTitle())
				   .publisher(document.getPublisher())
				   .edition(document.getEdition())
				   .photo(document.getPhoto().getBytes())
				   .publication(document.getPublication())
				   .price(document.getPrice(), document.getFiatCurrency())
				   .category(document.getCategory().toString(), document.getCategory().toString())
				   .contents(document.getContents())
				   .reviews(document.getReviews())
				   .popularity(document.getPopularity().toString())
				   .build();

	};
	

	private static final Converter<Book, BookDocument>
	BOOK_TO_BOOK_DOCUMENT_CONVERTER = 
	(context) -> {
		var book = context.getSource();
		var names = book.getAuthor();
		var bookDoc = new BookDocument();
		bookDoc.setIdentity(book.getIsbn().getValue());
		bookDoc.setAuthor(String.format("%s %s", 
				names.getFirst(), names.getLast()));
		bookDoc.setPublisher(book.getPublisher().getName());
		bookDoc.setEdition(book.getEdition().getValue());
		bookDoc.setPublication(book.getPublication().getValue());
		bookDoc.setPrice(book.getPrice().getPrice());
		bookDoc.setReviews(book.getReviews().getValue());
		bookDoc.setContents(book.getContents().getValue());
		bookDoc.setPhoto(book.getCoverPhoto().getBase64Values());
		bookDoc.setPopularity(book.getPopularity()
				        .stream()
				        .map(Popularity::name).toList());
		bookDoc.setCategory(book.getCategory().getName());
		return bookDoc;
	};

	@Bean
	public ModelMapper modelMapper() {
		var mapper = new ModelMapper();
		mapper.addConverter(BOOK_TO_BOOK_DOCUMENT_CONVERTER, 
				Book.class, BookDocument.class);
		mapper.addConverter(BOOK_DOCUMENT_TO_BOOK_CONVERTER, 
				BookDocument.class, Book.class);
		mapper.addConverter(BOOK_TO_BOOK_RESPONSE_CONVERTER, 
				Book.class, BookResponse.class);
		mapper.addConverter(BOOK_TO_REMOVE_BOOK_RESPONSE_CONVERTER, 
				Book.class, RemoveBookResponse.class);
		mapper.addConverter(BOOK_TO_ADD_BOOK_RESPONSE_CONVERTER, 
				Book.class, AddBookResponse.class);
		mapper.addConverter(ADD_BOOK_REQUEST_TO_BOOK_CONVERTER, 
				AddBookRequest.class, Book.class);
		return mapper;
	}
}