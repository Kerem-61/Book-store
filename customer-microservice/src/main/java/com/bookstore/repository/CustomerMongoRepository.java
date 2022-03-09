package com.bookstore.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bookstore.document.CustomerDocument;

public interface CustomerMongoRepository extends MongoRepository<CustomerDocument, String> {

	boolean existsByEmail(String email);
	Optional<CustomerDocument> findByEmail(String email);

}
