package com.bookstore.customer.application;

import java.util.Optional;

import com.bookstore.customer.domain.Customer;
import com.bookstore.customer.domain.Email;

public interface CustomerApplication {
	Customer addCustomer(Customer customer);

	Customer removeCustomer(Email email);

	Customer updateCustomer(Email email);
	
	Optional<Customer> findOneByEmail(Email email);

}
