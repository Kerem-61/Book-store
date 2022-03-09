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

import com.bookstore.dto.request.SaveStockRequest;
import com.bookstore.dto.response.RemoveStockResponse;
import com.bookstore.dto.response.SaveStockResponse;
import com.bookstore.dto.response.StockResponse;
import com.bookstore.service.StockService;
import com.bookstore.validation.Isbn;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestScope
@RequestMapping("stocks")
@CrossOrigin
@Validated
@Api(tags = "Stocks")
public class StockRestController {
	private StockService stockService;

	public StockRestController(StockService stockService) {
		super();
		this.stockService = stockService;
	}

	@GetMapping("{isbn}")
	@ApiOperation(value = "This method is used to get the book for the given {isbn}")
	public StockResponse getStockByIsbn(@PathVariable @Isbn String isbn) {
		return stockService.findStockByIsbn(isbn);
	}

	@PostMapping
	public SaveStockResponse saveStock(@RequestBody @Validated SaveStockRequest request) {
		return stockService.saveStock(request);
	}

	@DeleteMapping("{isbn}")
	public RemoveStockResponse removeStock(@PathVariable @Isbn String isbn) {
		return stockService.removeStock(isbn);
	}

}
