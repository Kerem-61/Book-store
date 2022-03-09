package com.bookstore.application.events;

public class CustomerEvent {
	private final String eventId;

	public CustomerEvent(String eventId) {
		this.eventId = eventId;
	}

	public String getEventId() {
		return eventId;
	}
	
	

}
