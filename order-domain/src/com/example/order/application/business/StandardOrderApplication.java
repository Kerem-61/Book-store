package com.example.order.application.business;

import java.util.List;
import java.util.Optional;

import com.example.order.application.OrderApplication;
import com.example.order.application.business.events.OrderCanceledEvent;
import com.example.order.application.business.events.OrderSentEvent;
import com.example.order.application.business.exceptions.ExistingOrderException;
import com.example.order.application.business.exceptions.OrderNotFoundException;
import com.example.order.domain.Book;
import com.example.order.domain.Order;
import com.example.order.domain.OrderId;
import com.example.order.infra.EventPublisher;
import com.example.order.repository.OrderRepository;

public class StandardOrderApplication implements OrderApplication {

	OrderRepository orderRepository;
	EventPublisher eventPublisher;

	public StandardOrderApplication(OrderRepository orderRepository, EventPublisher eventPublisher) {
		this.orderRepository = orderRepository;
		this.eventPublisher = eventPublisher;
	}

	@Override
	public Order sendOrder(Order order) {
		var value = order.getId();
		if (orderRepository.existById(value))
			throw new ExistingOrderException("Order already exist", order.getId());
		Order sentOrder = orderRepository.sendOrder(order);
		var businessEvent = new OrderSentEvent(sentOrder);
		eventPublisher.publishEvent(businessEvent);
		return sentOrder;
	}

	@Override
	public Optional<Order> cancelOrder(OrderId id) {

		Optional<Order> canceledOrder = orderRepository.cancelOrder(id);
		var order = canceledOrder.orElseThrow(() -> new OrderNotFoundException("Order does not exist", id.getValue()));
		eventPublisher.publishEvent(new OrderCanceledEvent(order));
		return Optional.of(order);
	}

	@Override
	public List<Order> findAllOrders() {
		return orderRepository.findAllOrders();
	}

	@Override
	public Optional<Order> findOrderByIsbn(Book isbn) {

		return orderRepository.findByIsbn(isbn);
	}

}
