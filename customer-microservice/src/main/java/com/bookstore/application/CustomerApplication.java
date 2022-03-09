package com.bookstore.application;

import java.util.List;

import com.bookstore.dto.request.CustomerRequest;
import com.bookstore.dto.request.UpdateCustomerRequest;
import com.bookstore.dto.response.CustomerResponse;
import com.bookstore.dto.response.RemoveCustomerResponse;

public interface CustomerApplication {
	
	CustomerResponse findCustomerByEmail(String email);

	RemoveCustomerResponse removeCustomerByEmail(String email);
	
	List<CustomerResponse> findCustomers(int page,int size);
	
	CustomerResponse updateCustomer(String email,UpdateCustomerRequest request);

	CustomerResponse addCustomer(CustomerRequest request);

}
