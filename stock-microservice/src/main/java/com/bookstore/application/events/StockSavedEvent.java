package com.bookstore.application.events;

import java.util.UUID;

import com.bookstore.dto.response.StockResponse;

public class StockSavedEvent extends StockEvent {
	private final StockResponse stock;

	public StockSavedEvent(StockResponse stock) {
		super(UUID.randomUUID().toString());
		this.stock = stock;
	}

	public StockResponse getStock() {
		return stock;
	}

}
