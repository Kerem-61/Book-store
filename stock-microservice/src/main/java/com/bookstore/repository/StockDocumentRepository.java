package com.bookstore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bookstore.document.StockDocument;
import com.bookstore.stock.domain.Isbn;
import com.bookstore.stock.domain.Stock;

public interface StockDocumentRepository extends MongoRepository<StockDocument, String> {
	
	public Stock findStockByIsbn(Isbn isbn);
}
