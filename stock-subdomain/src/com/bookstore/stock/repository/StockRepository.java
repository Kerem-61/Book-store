package com.bookstore.stock.repository;

import java.util.Optional;

import com.bookstore.stock.domain.Isbn;
import com.bookstore.stock.domain.Stock;

public interface StockRepository {

	Optional<Stock> findStockByIsbn(Isbn isbn);
}
