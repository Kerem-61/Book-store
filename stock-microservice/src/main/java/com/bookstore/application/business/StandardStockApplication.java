package com.bookstore.application.business;

import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.bookstore.application.StockApplication;
import com.bookstore.application.business.exceptions.StockAlreadyExistException;
import com.bookstore.application.business.exceptions.StockNotFoundException;
import com.bookstore.application.events.StockRemovedEvent;
import com.bookstore.application.events.StockSavedEvent;
import com.bookstore.document.StockDocument;
import com.bookstore.dto.request.SaveStockRequest;
import com.bookstore.dto.response.RemoveStockResponse;
import com.bookstore.dto.response.SaveStockResponse;
import com.bookstore.dto.response.StockResponse;
import com.bookstore.repository.StockMongoRepository;

@Service
public class StandardStockApplication implements StockApplication {

	StockMongoRepository stockMongoRepository;
	private ModelMapper modelMapper;
	private ApplicationEventPublisher eventPublisher;

	public StandardStockApplication(StockMongoRepository stockMongoRepository, ModelMapper modelMapper,
			ApplicationEventPublisher eventPublisher) {
		this.stockMongoRepository = stockMongoRepository;
		this.modelMapper = modelMapper;
		this.eventPublisher = eventPublisher;
	}

	public StandardStockApplication(StockMongoRepository stockMongoRepository,
			ApplicationEventPublisher eventPublisher) {
		this.stockMongoRepository = stockMongoRepository;
		this.eventPublisher = eventPublisher;
	}

	@Override
	public StockResponse findStockByIsbn(String isbn) {
		var stock = stockMongoRepository.findById(isbn).orElseThrow(() -> new StockNotFoundException());
		return modelMapper.map(stock, StockResponse.class);
	}


	@Override
	public RemoveStockResponse removeStock(String isbn) {
		var stock = stockMongoRepository.findById(isbn).orElseThrow(() -> new StockNotFoundException());
		stockMongoRepository.delete(stock);
		var removeStockResponse = modelMapper.map(stock, RemoveStockResponse.class);
		var stockRemovedEvent = new StockRemovedEvent(modelMapper.map(stock, StockResponse.class));
		eventPublisher.publishEvent(stockRemovedEvent);
		return removeStockResponse;
	}

	@Override
	public SaveStockResponse saveStock(SaveStockRequest request) {
			var identity = request.getIdentity();
			if (stockMongoRepository.existsById(identity))
				throw new StockAlreadyExistException();
			var stock = modelMapper.map(request, StockDocument.class);
			stock = stockMongoRepository.insert(stock);
			var stockSavedEvent = new StockSavedEvent(modelMapper.map(stock, StockResponse.class));
			eventPublisher.publishEvent(stockSavedEvent);
			return modelMapper.map(stock, SaveStockResponse.class);
		}
	}

