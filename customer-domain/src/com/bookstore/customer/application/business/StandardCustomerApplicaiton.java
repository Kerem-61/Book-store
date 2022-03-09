package com.bookstore.customer.application.business;

import java.util.Optional;

import com.bookstore.customer.application.CustomerApplication;
import com.bookstore.customer.application.business.events.CustomerAddEvent;
import com.bookstore.customer.application.business.events.CustomerDeleteEvent;
import com.bookstore.customer.application.business.exception.CustomerAlreadyExistException;
import com.bookstore.customer.application.business.exception.CustomerNotFoundException;
import com.bookstore.customer.domain.Customer;
import com.bookstore.customer.domain.Email;
import com.bookstore.customer.infastructure.EventPublisher;
import com.bookstore.customer.repository.CustomerRepository;

public class StandardCustomerApplicaiton implements CustomerApplication {
	private CustomerRepository customerRepository;
	private EventPublisher event;

	@Override
	public Customer addCustomer(Customer customer) {
		var email=customer.getEmail();
		if(customerRepository.existByEmail(email))
			throw new CustomerAlreadyExistException("Customer has already here", email.getValue());
		Customer savedCustomer= customerRepository.save(customer);
		var customerEvent=new CustomerAddEvent(savedCustomer);
		event.publishEvent(customerEvent);
		return savedCustomer;
	}

	@Override
	public Customer removeCustomer(Email email) {
		Optional<Customer> removedCustomer=customerRepository.remove(email);
		var customer= removedCustomer.orElseThrow(()-> new CustomerNotFoundException("Customer can't find", email.getValue()));
		event.publishEvent(new CustomerDeleteEvent(customer));
		return customer;
	}

	@Override
	public Customer updateCustomer(Email email) {
		var customer = customerRepository.findOneByEmail(email)
				.orElseThrow(()->new CustomerNotFoundException("Customer can't find", email.getValue()));
		return customerRepository.save(customer);
	}

	@Override
	public Optional<Customer> findOneByEmail(Email email) {
		
		return customerRepository.findOneByEmail(email);
	}

	
}
