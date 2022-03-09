package com.example.publishermicroservice.repository;

import com.bookstore.domain.Publisher;
import com.example.publishermicroservice.document.PublisherDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.awt.print.Book;
import java.util.Optional;
import java.util.concurrent.Flow;

public interface PublisherMongoRepository extends MongoRepository {
    Optional<PublisherDocument> findById(String id);
    Publisher findPublisherByBook(Book book);
}
