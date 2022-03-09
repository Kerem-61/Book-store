package com.bookstore.stock.application;

import java.util.Optional;

import com.bookstore.stock.domain.Isbn;
import com.bookstore.stock.domain.Stock;

public interface StockApplication {
	
	Optional<Stock> findStockByIsbn(Isbn isbn);
	
	
	
}
