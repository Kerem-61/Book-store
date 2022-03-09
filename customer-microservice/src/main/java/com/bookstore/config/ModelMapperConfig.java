package com.bookstore.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bookstore.customer.domain.Customer;
import com.bookstore.document.CustomerDocument;
import com.bookstore.dto.request.CustomerRequest;
import com.bookstore.dto.response.CustomerResponse;
import com.bookstore.dto.response.RemoveCustomerResponse;

@Configuration
public class ModelMapperConfig {
	
	private static final Converter<Customer, RemoveCustomerResponse>
	CUSTOMER_TO_REMOVE_CUSTOMER_RESPONSE_CONVERTER = 
	(context) -> {
		 var customer = context.getSource();
		   var fullname = customer.getFullname();
		   var response = new RemoveCustomerResponse();
		   response.setFullname(String.format("%s %s", 
			fullname.getFirst(), fullname.getLast()));
           response.setEmail(customer.getEmail().getValue());
           response.setIsAdmin(customer.getIsAdmin().isAdmin());
		   return response;
		  
	};
	
	private static final Converter<Customer, CustomerResponse>
	CUSTOMER_TO_CUSTOMER_RESPONSE_CONVERTER = 
	(context) -> {
		var customer = context.getSource();
		   var fullname = customer.getFullname();
		   var response = new CustomerResponse();
		   response.setFullname(String.format("%s %s", 
					fullname.getFirst(),fullname.getLast()));
		   response.setBirthYear(customer.getBirthYear().getValue());
		   response.setLocations(customer.getLocation());
		   response.setInterests(customer.getInterests());
		   response.setEmail(customer.getEmail().getValue());
		   response.setEpurse(customer.getEpurse().getValue());
		   response.setPassword(customer.getPassword().getValue());
		   response.setIsAdmin(customer.getIsAdmin().isAdmin());
		   return response;
		   
		   
	};
	
	private static final Converter<CustomerRequest, Customer>
	CUSTOMER_REQUEST_TO_CUSTOMER_CONVERTER = 
	(context) -> {
		var request = context.getSource();
		return new Customer.Builder()
				.fullname(request.getFirstName(),request.getLastName())
				.birthYear(request.getBirthYear())
				.interests(request.getInterests())
				.email(request.getEmail())
				.epurse(request.getEpurse())
				.password(request.getPassword())
				.isAdmin(request.getIsAdmin())
				.build();
			
				
	};
	
	private static final Converter<CustomerDocument, Customer>
	CUSTOMER_DOCUMENT_TO_CUSTOMER_CONVERTER = 
			(context) -> {
				var document = context.getSource();
				var names = document.getFullname().split(" ");
				return new Customer.Builder()
						.fullname(names[0], names[1])
						.birthYear(document.getBirthYear())
						.locations(null, null, null, null)
						.interests(document.getInterests().toArray(new String[0]))
						.email(document.getEmail())
						.epurse(document.getEpurse())
						.password(document.getPassword())
						.isAdmin(document.getIsAdmin())
						.build();
						
			};
				  

	private static final Converter<Customer, CustomerDocument>
	CUSTOMER_TO_CUSTOMER_DOCUMENT_CONVERTER = 
	(context) -> {
		var customer = context.getSource();
		var fullname = customer.getFullname();
		var cusDoc = new CustomerDocument();
		cusDoc.setEmail(customer.getEmail().getValue());
		cusDoc.setFullname(String.format("%s %s",
				fullname.getFirst(),fullname.getLast()));
		cusDoc.setBirthYear(customer.getBirthYear().getValue());
		cusDoc.setLocations(customer.getLocation());
		cusDoc.setInterests(customer.getInterests());
		cusDoc.setEpurse(customer.getEpurse().getValue());
		cusDoc.setPassword(customer.getPassword().getValue());
		cusDoc.setIsAdmin(customer.getIsAdmin().isAdmin()); 
		
		return cusDoc;
	};

	@Bean
	public ModelMapper modelMapper() {
		var mapper = new ModelMapper();
		mapper.addConverter(CUSTOMER_TO_CUSTOMER_DOCUMENT_CONVERTER, 
				Customer.class, CustomerDocument.class);
		mapper.addConverter(CUSTOMER_DOCUMENT_TO_CUSTOMER_CONVERTER, 
				CustomerDocument.class, Customer.class);
		mapper.addConverter(CUSTOMER_TO_CUSTOMER_RESPONSE_CONVERTER, 
				Customer.class, CustomerResponse.class);
		mapper.addConverter(CUSTOMER_TO_REMOVE_CUSTOMER_RESPONSE_CONVERTER, 
				Customer.class, RemoveCustomerResponse.class);
		mapper.addConverter(CUSTOMER_REQUEST_TO_CUSTOMER_CONVERTER, 
				CustomerRequest.class, Customer.class);
		return mapper;
	}
}
