package com.bookstore.service.business;

import org.modelmapper.ModelMapper;

import com.bookstore.application.StockApplication;
import com.bookstore.application.business.exceptions.StockNotFoundException;
import com.bookstore.dto.request.SaveStockRequest;
import com.bookstore.dto.response.RemoveStockResponse;
import com.bookstore.dto.response.SaveStockResponse;
import com.bookstore.dto.response.StockResponse;
import com.bookstore.service.StockService;

public class StandartStockService implements StockService {
	private StockApplication stockApplication;
	private ModelMapper modelMapper;

	public StandartStockService(StockApplication stockApplication, ModelMapper modelMapper) {
		this.stockApplication = stockApplication;
		this.modelMapper = modelMapper;
	}

	@Override
	public StockResponse findStockByIsbn(String isbn) {
		var stock = stockApplication.findStockByIsbn(String.valueOf(isbn));
		if (stock.getIsbn().isEmpty())
			throw new StockNotFoundException();
		return modelMapper.map(stock.getStockNumber(), StockResponse.class);
	}

	@Override
	public SaveStockResponse saveStock(SaveStockRequest request) {
		var savedStock = stockApplication.saveStock(request);
		return modelMapper.map(savedStock, SaveStockResponse.class);
	}

	@Override
	public RemoveStockResponse removeStock(String isbn) {
		var stock = stockApplication.removeStock(String.valueOf(isbn));
		return modelMapper.map(stock, RemoveStockResponse.class);
	}

}
