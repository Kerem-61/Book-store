package com.bookstore.stock.application.business.events;

import com.bookstore.stock.domain.Stock;

public class StockRemoveEvent extends StockEvent {
	private final Stock stock;

	public Stock getStock() {
		return stock;
	}

	public StockRemoveEvent(Stock stock) {
		this.stock = stock;
	}

}
