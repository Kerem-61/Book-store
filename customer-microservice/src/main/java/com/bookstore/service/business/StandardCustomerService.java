package com.bookstore.service.business;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.bookstore.application.CustomerApplication;
import com.bookstore.application.business.exceptions.CustomerNotFoundException;
import com.bookstore.dto.request.CustomerRequest;
import com.bookstore.dto.response.CustomerResponse;
import com.bookstore.dto.response.RemoveCustomerResponse;
import com.bookstore.service.CustomerService;

@Service
public class StandardCustomerService implements CustomerService {

	private CustomerApplication customerApplication;
	private ModelMapper modelMapper;

	public StandardCustomerService(CustomerApplication customerApplication, ModelMapper modelMapper) {
		this.customerApplication = customerApplication;
		this.modelMapper = modelMapper;
	}

	@Override
	public CustomerResponse findCustomerByEmail(String email) {
		var customer = customerApplication.findCustomerByEmail(email);
		if (customer.getEmail().isEmpty())
			throw new CustomerNotFoundException();

		return modelMapper.map(customer.getEmail(), CustomerResponse.class);
	}

	@Override
	public CustomerResponse addCustomer(CustomerRequest request) {
		var addedCustomer = customerApplication.addCustomer(request);
		
		return modelMapper.map(addedCustomer, CustomerResponse.class);
	}

	@Override
	public RemoveCustomerResponse removeCustomerByEmail(String email) {
		var customer = customerApplication.removeCustomerByEmail(email);
		
		return modelMapper.map(customer, RemoveCustomerResponse.class);
	}

}
