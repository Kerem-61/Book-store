package com.bookstore.customer.application.business.events;

import com.bookstore.customer.domain.Customer;

public class CustomerDeleteEvent extends CustomerEvent {
	private final Customer customer;

	public CustomerDeleteEvent(Customer customer) {
		
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

}