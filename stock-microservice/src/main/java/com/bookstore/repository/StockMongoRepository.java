package com.bookstore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bookstore.document.StockDocument;
import com.bookstore.stock.domain.Stock;
import com.bookstore.validation.Isbn;

public interface StockMongoRepository extends MongoRepository<StockDocument, String>{
	Stock findStockByIsbn(Isbn isbn);

	boolean existsById(int identity);
}
