package com.bookstore.service;

import com.bookstore.dto.request.CustomerRequest;
import com.bookstore.dto.response.CustomerResponse;
import com.bookstore.dto.response.RemoveCustomerResponse;

public interface CustomerService {

	CustomerResponse findCustomerByEmail(String email);
	
	CustomerResponse addCustomer(CustomerRequest request);
	
	RemoveCustomerResponse removeCustomerByEmail(String email);
	
}
