package com.bookstore.controller;

import javax.validation.constraints.Email;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.bookstore.dto.request.CustomerRequest;
import com.bookstore.dto.response.CustomerResponse;
import com.bookstore.dto.response.RemoveCustomerResponse;
import com.bookstore.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestScope
@RequestMapping("customers")
@CrossOrigin
@Validated
@Api( tags = "Customers")

public class CustomerRestController {

	private CustomerService customerService;

	public CustomerRestController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("{email}")
	@ApiOperation(value = "This method is used to get the customer for the given {email}\"")
	public CustomerResponse getCustomerByEmail(@PathVariable @Email String email) {
		return customerService.findCustomerByEmail(email);
	}
	
	
	@PostMapping
	public CustomerResponse addCustomer(
			@RequestBody @Validated CustomerRequest request) {
		return customerService.addCustomer(request);
	}

	@DeleteMapping("{email}")
	public RemoveCustomerResponse removeCustomer(
			@PathVariable @Email String email) {
		return customerService.removeCustomerByEmail(email);
	}
	

}
