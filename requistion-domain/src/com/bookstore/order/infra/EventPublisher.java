package com.bookstore.order.infra;

import com.bookstore.application.business.events.RequistionEvent;

public interface EventPublisher{
	void publishEvent(RequistionEvent event);	
}
