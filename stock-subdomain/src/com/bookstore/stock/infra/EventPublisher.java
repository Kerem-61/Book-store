package com.bookstore.stock.infra;

public interface EventPublisher<Event> {
	void publishEvent(Event event);	
}
