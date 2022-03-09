package com.bookstore.customer.application.business.events;

import com.bookstore.customer.domain.Customer;

public class CustomerAddEvent extends CustomerEvent {
	private final Customer customer;

	public CustomerAddEvent(Customer customer) {
		
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

}
