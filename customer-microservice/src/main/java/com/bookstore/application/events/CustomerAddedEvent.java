package com.bookstore.application.events;

import java.util.UUID;

import com.bookstore.dto.response.CustomerResponse;

public class CustomerAddedEvent  extends CustomerEvent{

private final CustomerResponse customer;

public CustomerAddedEvent(CustomerResponse customer) {
	super(UUID.randomUUID().toString());
	this.customer = customer;
}

public CustomerResponse getCustomer() {
	return customer;
}


	
	
	

}
