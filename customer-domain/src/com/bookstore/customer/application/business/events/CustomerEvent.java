package com.bookstore.customer.application.business.events;

import java.util.UUID;

public class CustomerEvent {
	private final String eventEmail;

	public CustomerEvent() {
		this.eventEmail = UUID.randomUUID().toString();
	}

	public String getEventEmail() {
		return eventEmail;
	}
}
