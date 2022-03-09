package com.bookstore.customer.repository;

import java.util.Optional;

import com.bookstore.customer.domain.Customer;
import com.bookstore.customer.domain.Email;


public interface CustomerRepository {
	boolean existByEmail(Email email);

	Customer save(Customer customer);

	Optional<Customer> remove(Email email);

	Optional<Customer> findOneByEmail(Email email);
	

}
