package com.example.order.application.business.exceptions;

import com.example.order.domain.OrderId;

@SuppressWarnings("serial")
public class ExistingOrderException extends RuntimeException {
private final String identity;
private OrderId orderId;
	

	public ExistingOrderException(String identity, OrderId orderId) {
		
		this.identity = identity;
		this.orderId = orderId;
	}


	public String getIdentity() {
		return identity;
	}


	public OrderId getOrderId() {
		return orderId;
	}


	public void setOrder(OrderId orderId) {
		this.orderId = orderId;
	}
	

}
