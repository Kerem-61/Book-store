package com.bookstore.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.bookstore.dto.request.AddBookRequest;
import com.bookstore.dto.response.AddBookResponse;
import com.bookstore.dto.response.BookResponse;
import com.bookstore.dto.response.RemoveBookResponse;
import com.bookstore.service.BookService;
import com.bookstore.validation.Isbn;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestScope
@RequestMapping("books")
@CrossOrigin
@Validated
@Api( tags = "Books")
public class BookRestController {

	private BookService bookService;

	 
	public BookRestController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("{isbn}")
	@ApiOperation(value = "This method is used to get the book for the given {isbn}")
	public BookResponse getBookByIsbn(
			@PathVariable @Isbn String isbn) {
		return bookService.findBookByIsbn(isbn);
	}
	
	@PostMapping
	public AddBookResponse addBook(
			@RequestBody @Validated AddBookRequest request) {
		return bookService.addBook(request);
	}

	@DeleteMapping("{isbn}")
	public RemoveBookResponse removeBook(
			@PathVariable @Isbn String isbn) {
		return bookService.removeBookByIsbn(isbn);
	}
}
