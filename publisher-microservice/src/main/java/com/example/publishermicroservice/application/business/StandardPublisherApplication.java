package com.example.publishermicroservice.application.business;

import com.example.publishermicroservice.application.PublisherApplication;
import com.example.publishermicroservice.application.business.exceptions.PublisherNotFoundException;
import com.example.publishermicroservice.application.events.PublisherAddedEvent;
import com.example.publishermicroservice.document.PublisherDocument;
import com.example.publishermicroservice.dto.request.AddPublisherRequest;
import com.example.publishermicroservice.dto.response.AddPublisherResponse;
import com.example.publishermicroservice.dto.response.PublisherResponse;
import com.example.publishermicroservice.repository.PublisherMongoRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.PageRequest;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.List;

public class StandardPublisherApplication implements PublisherApplication {
    PublisherMongoRepository publisherMongoRepository;
    private ModelMapper modelMapper;
    private ApplicationEventPublisher eventPublisher;



    public StandardPublisherApplication(PublisherMongoRepository publisherMongoRepository, ApplicationEventPublisher eventPublisher) {
        this.publisherMongoRepository = publisherMongoRepository;
        this.eventPublisher = eventPublisher;
    }


    public StandardPublisherApplication(PublisherMongoRepository publisherMongoRepository, ModelMapper modelMapper,
                                   ApplicationEventPublisher eventPublisher) {
        this.publisherMongoRepository = publisherMongoRepository;
        this.modelMapper = modelMapper;
        this.eventPublisher = eventPublisher;
    }


    @Override
    public PublisherResponse findPublisherById(String id) {
        var publisher = publisherMongoRepository.findById(id).orElseThrow(() -> new PublisherNotFoundException());
        return modelMapper.map(publisher, PublisherResponse.class);
    }


    public AddPublisherResponse addBook(AddPublisherRequest request) throws PublisherNotFoundException {
        var identity = request.getIdentity();
        if( publisherMongoRepository.existsById(identity))
            throw new PublisherNotFoundException();
        var publisher = modelMapper.map(request, PublisherDocument.class);
        publisher = publisherMongoRepository.insert(publisher);
        var publisherAddedEvent = new PublisherAddedEvent(modelMapper.map(publisher,PublisherResponse.class));
        eventPublisher.publishEvent(publisherAddedEvent);
        return modelMapper.map(publisher, AddPublisherResponse.class);
    }

    @Override
    public List<PublisherResponse> findPublishers(int page, int size) {
        var pageRequest = PageRequest.of(page, size);
        return publisherMongoRepository.findAll(pageRequest).stream().map(emp -> modelMapper.map(emp, PublisherResponse.class))
                .toList();
    }




}
