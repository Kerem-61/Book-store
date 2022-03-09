package com.example.order.application.business.events;

import com.example.order.domain.Order;

public class OrderCanceledEvent extends OrderEvent{
	private final Order order;


	public OrderCanceledEvent(Order order) {
		this.order = order;
	}


	public Order getOrder() {
		return order;
	}
	
	




}
