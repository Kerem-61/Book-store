package com.bookstore.stock.application.business;

import java.util.Optional;

import com.bookstore.stock.application.StockApplication;
import com.bookstore.stock.domain.Isbn;
import com.bookstore.stock.domain.Stock;
import com.bookstore.stock.repository.StockRepository;

public class StandardStockApplication implements StockApplication {

	StockRepository stockRepository;
	
	
	public StandardStockApplication(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}


	@Override
	public Optional<Stock> findStockByIsbn(Isbn isbn) {
		// TODO Auto-generated method stub
		return stockRepository.findStockByIsbn(isbn);
	}


}
