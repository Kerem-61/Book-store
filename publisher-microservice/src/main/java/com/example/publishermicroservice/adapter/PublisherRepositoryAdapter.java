package com.example.publishermicroservice.adapter;

import com.bookstore.domain.Publisher;
import com.bookstore.domain.PublisherId;
import com.bookstore.repository.PublisherRepository;
import com.example.publishermicroservice.document.PublisherDocument;
import com.example.publishermicroservice.repository.PublisherDocumentRepository;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Flow;

public class PublisherRepositoryMongoAdaptor implements PublisherRepository {

    private PublisherDocumentRepository mongoRepo;
    private ModelMapper mapper;

    public PublisherRepositoryMongoAdaptor(PublisherDocumentRepository mongoRepo, ModelMapper mapper) {
        this.mongoRepo = mongoRepo;
        this.mapper = mapper;
    }


    public Optional<Publisher> findPublisherBId(PublisherId publisherId) {
        return mongoRepo.findPublisherById(publisherId.toString())
                .map(doc -> mapper.map(doc, Publisher.class));
    }


    @Override
    public Publisher addStock(String stock) {
        return null;
    }

    public List<Publisher> findAllPublishers() {
        return mongoRepo.findAllPublishers()
                .map(doc -> mapper.map(doc, Publisher.class));
    }


    public Publisher savePublisher(Publisher publisher) {
        var document = mapper.map(publisher, PublisherDocument.class);
        return mapper.map(mongoRepo.save(document), Publisher.class);
    }

    @Override
    public boolean existById(PublisherId publisherId) {
        return false;
    }


}
