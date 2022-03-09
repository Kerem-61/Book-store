package com.example.order.application.business.events;

import com.example.order.domain.Order;

public class OrderSentEvent extends OrderEvent{
	private final Order order;

	public OrderSentEvent(Order order) {
		this.order = order;
	}
	public Order getOrder() {
		return order;
	}

	
	
	

}
