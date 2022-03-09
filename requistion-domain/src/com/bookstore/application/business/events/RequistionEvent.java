package com.bookstore.application.business.events;

import java.util.UUID;

public class RequistionEvent {
	private final String eventId;

	public RequistionEvent() {
		this.eventId = UUID.randomUUID().toString();
	}

	public String getEventId() {
		return eventId;
	}
}
