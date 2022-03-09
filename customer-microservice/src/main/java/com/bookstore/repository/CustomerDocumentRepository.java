package com.bookstore.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bookstore.document.CustomerDocument;

public interface CustomerDocumentRepository extends MongoRepository<CustomerDocument, String> {
	
	Optional<CustomerDocument> findByEmail(String email);

	boolean existsByEmail(String email);


	
	

}
