package com.example.order.repository;

import java.util.List;
import java.util.Optional;

import com.example.order.domain.Book;
import com.example.order.domain.Order;
import com.example.order.domain.OrderId;

public interface OrderRepository {

	Order sendOrder(Order order);

	Optional<Order> cancelOrder(OrderId id);

	Optional<Order> findByIsbn(Book isbn);

	List<Order> findAllOrders();

	boolean existById(OrderId value);

}
