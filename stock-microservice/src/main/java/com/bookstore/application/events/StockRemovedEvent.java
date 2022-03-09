package com.bookstore.application.events;

import java.util.UUID;

import com.bookstore.dto.response.StockResponse;

public class StockRemovedEvent extends StockEvent {
private final StockResponse stock;


public StockRemovedEvent(StockResponse stock) {
	super(UUID.randomUUID().toString());
	this.stock = stock;
}

public StockResponse getStock() {
	return stock;
}

}
