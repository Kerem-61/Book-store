package com.example.order.infra;

import com.example.order.application.business.events.OrderEvent;

public interface EventPublisher{
	void publishEvent(OrderEvent event);	
}
