package com.bookstore.application.events;

public class BookEvent {
	private final String eventId;

	public BookEvent(String eventId) {
		this.eventId = eventId;
	}

	public String getEventId() {
		return eventId;
	}
}
