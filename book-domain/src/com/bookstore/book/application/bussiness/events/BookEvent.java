package com.bookstore.book.application.bussiness.events;

import java.util.UUID;

public class BookEvent {
	private final String eventId;

	public BookEvent() {
		this.eventId = UUID.randomUUID().toString();
	}

	public String getEventId() {
		return eventId;
	}
}
