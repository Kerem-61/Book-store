package com.bookstore.application;

import java.util.List;

import com.bookstore.dto.request.AddBookRequest;
import com.bookstore.dto.request.UpdateBookRequest;
import com.bookstore.dto.response.AddBookResponse;
import com.bookstore.dto.response.BookResponse;
import com.bookstore.dto.response.RemoveBookResponse;

public interface BookApplication {
	
	BookResponse findBookByIsbn(String isbn);

	RemoveBookResponse removeBook(String isbn);
	
	List<BookResponse> findBooks(int page,int size);
	
	BookResponse updateBook(String identity, UpdateBookRequest request);

	AddBookResponse addBook(AddBookRequest request);

	

}
