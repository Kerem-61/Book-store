package com.bookstore.stock.application.business.events;

import com.bookstore.stock.domain.Stock;

public class StockSavedEvent extends StockEvent {
	private final Stock stock;

	public StockSavedEvent(Stock stock) {
		this.stock = stock;
	}

	public Stock getStock() {
		return stock;
	}

}
