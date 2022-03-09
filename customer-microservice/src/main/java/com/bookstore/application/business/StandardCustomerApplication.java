package com.bookstore.application.business;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.PageRequest;

import com.bookstore.application.CustomerApplication;
import com.bookstore.application.business.exceptions.CustomerAlreadyExistException;
import com.bookstore.application.business.exceptions.CustomerNotFoundException;
import com.bookstore.application.events.CustomerAddedEvent;
import com.bookstore.application.events.RemoveCustomerEvent;
import com.bookstore.document.CustomerDocument;
import com.bookstore.dto.request.CustomerRequest;
import com.bookstore.dto.request.UpdateCustomerRequest;
import com.bookstore.dto.response.CustomerResponse;
import com.bookstore.dto.response.RemoveCustomerResponse;
import com.bookstore.repository.CustomerMongoRepository;

public class StandardCustomerApplication implements CustomerApplication {

	CustomerMongoRepository customerMongoRepository;
	private ModelMapper modelMapper;
	private ApplicationEventPublisher eventPuslisher;

	public StandardCustomerApplication(CustomerMongoRepository customerMongoRepository,
			ApplicationEventPublisher eventPuslisher) {
		this.customerMongoRepository = customerMongoRepository;
		this.eventPuslisher = eventPuslisher;
	}

	@Override
	public CustomerResponse findCustomerByEmail(String email) {
		var customer = customerMongoRepository.findByEmail(email)
				.orElseThrow(() -> new CustomerNotFoundException());
		return modelMapper.map(customer, CustomerResponse.class);
	}

	@Override
	public RemoveCustomerResponse removeCustomerByEmail(String email) {
		var customer = customerMongoRepository.findByEmail(email)
				.orElseThrow(()-> new CustomerNotFoundException());
		customerMongoRepository.delete(customer);
		
		var removeCustomerResponse = modelMapper.map(customer,RemoveCustomerResponse.class);
		var customerRemovedEvent = new RemoveCustomerEvent(modelMapper.map(customer, CustomerResponse.class));
		eventPuslisher.publishEvent(customerRemovedEvent);
		return removeCustomerResponse;
	}

	@Override
	public List<CustomerResponse> findCustomers(int page, int size) {
		var pageRequest = PageRequest.of(page, size);
		return customerMongoRepository.findAll(pageRequest)
				.stream()
				.map(cust->modelMapper.map(cust, CustomerResponse.class))
				.toList();
	}

	@Override
	public CustomerResponse updateCustomer(String email,UpdateCustomerRequest request) {
		var customer = customerMongoRepository.findByEmail(email)
				.orElseThrow(()-> new CustomerNotFoundException());
       modelMapper.map(request, customer);
       customer.setEmail(email);
		return modelMapper.map(customerMongoRepository.save(customer), CustomerResponse.class);
	}

	@Override
	public CustomerResponse addCustomer(CustomerRequest request) {
		var email = request.getEmail();
		if(customerMongoRepository.existsByEmail(email))
			throw new CustomerAlreadyExistException();
		var customer = modelMapper.map(request, CustomerDocument.class);
		customer = customerMongoRepository.insert(customer);
	  var customerAddedEvent = new CustomerAddedEvent(modelMapper.map(customer,CustomerResponse.class));
	  eventPuslisher.publishEvent(customerAddedEvent);
	  
	  return modelMapper.map(customer, CustomerResponse.class);
	}

}
