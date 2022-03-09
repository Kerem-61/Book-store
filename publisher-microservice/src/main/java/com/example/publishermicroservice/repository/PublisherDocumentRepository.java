package com.example.publishermicroservice.repository;

import com.bookstore.domain.Publisher;
import com.example.publishermicroservice.document.PublisherDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PublisherDocumentRepository extends MongoRepository<PublisherDocument, String> {
    Optional<PublisherDocument> findById(String id);
    Optional<PublisherDocument> findPublisherById(String id);

    Publisher findAllPublishers();
}
