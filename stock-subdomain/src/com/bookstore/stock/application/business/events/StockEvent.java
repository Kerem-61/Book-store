package com.bookstore.stock.application.business.events;

import java.util.UUID;

public class StockEvent {
	private final String stockId;

	public StockEvent() {
		this.stockId = UUID.randomUUID().toString();
	}

	public String getEventId() {
		return stockId;
	}
}
