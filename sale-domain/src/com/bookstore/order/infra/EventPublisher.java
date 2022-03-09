package com.bookstore.order.infra;

import com.bookstore.application.business.events.SaleEvent;

public interface EventPublisher{
	void publishEvent(SaleEvent event);	
}
