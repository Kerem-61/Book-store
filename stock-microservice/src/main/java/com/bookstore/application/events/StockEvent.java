package com.bookstore.application.events;

public class StockEvent {
	private final String eventId;

	public StockEvent(String eventId) {
		this.eventId = eventId;
	}

	public String getEventId() {
		return eventId;
	}

}
