package com.bookstore.adapter;

import java.util.Optional;

import org.modelmapper.ModelMapper;

import com.bookstore.customer.domain.Customer;
import com.bookstore.customer.domain.Email;
import com.bookstore.customer.repository.CustomerRepository;
import com.bookstore.document.CustomerDocument;
import com.bookstore.repository.CustomerDocumentRepository;

public class CustomerRepositoryMongoAdaptor implements CustomerRepository {

	private CustomerDocumentRepository mongoRepo;
	private ModelMapper modelMapper;
	
	
	public CustomerRepositoryMongoAdaptor(CustomerDocumentRepository mongoRepo, ModelMapper modelMapper) {
		this.mongoRepo = mongoRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public boolean existByEmail(Email email) {
		
		return mongoRepo.existsByEmail(email.getValue());
	}

	@Override
	public Customer save(Customer customer) {
		var document = modelMapper.map(customer, CustomerDocument.class);
		return modelMapper.map(mongoRepo.save(document), Customer.class);
	}

	@Override
	public Optional<Customer> remove(Email email) {
		var document = mongoRepo.findByEmail(email.getValue());
		document.ifPresent(mongoRepo::delete);
		return document.map(doc->modelMapper.map(doc,Customer.class));
	}

	@Override
	public Optional<Customer> findOneByEmail(Email email) {

		return mongoRepo.findByEmail(email.getValue())
				.map(doc->modelMapper.map(doc, Customer.class));

}
}