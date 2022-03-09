package com.bookstore.adapter;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.bookstore.document.StockDocument;
import com.bookstore.repository.StockDocumentRepository;
import com.bookstore.stock.domain.Isbn;
import com.bookstore.stock.domain.Stock;
import com.bookstore.stock.repository.StockRepository;

@Repository
public class StockRepositoryMongoAdaptor implements StockRepository {

	private StockDocumentRepository mongoRepo;
	private ModelMapper mapper;

	public StockRepositoryMongoAdaptor(StockDocumentRepository mongoRepo, ModelMapper mapper) {
		this.mongoRepo = mongoRepo;
		this.mapper = mapper;
	}

	@Override
	public Optional<Stock> remove(Isbn isbn) {
		return null;
	}

	@Override
	public Stock save(Stock stock) {
		var document = mapper.map(stock, StockDocument.class);
		return mapper.map(mongoRepo.save(document), Stock.class);
	}

	@Override
	public Stock findStockByIsbn(Isbn isbn) {
		// TODO Auto-generated method stub
		return null;
	}





}
