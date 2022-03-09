package com.example.order.application;

import java.util.List;
import java.util.Optional;

import com.example.order.domain.Book;
import com.example.order.domain.Order;
import com.example.order.domain.OrderId;

public interface OrderApplication {

	Order sendOrder(Order order);

	Optional<Order> cancelOrder(OrderId id);

	List<Order> findAllOrders();

	Optional<Order> findOrderByIsbn(Book isbn);
}
