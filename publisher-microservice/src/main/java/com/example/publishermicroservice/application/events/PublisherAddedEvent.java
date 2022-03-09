package com.example.publishermicroservice.application.events;

import com.example.publishermicroservice.dto.response.PublisherResponse;

import java.util.UUID;

import static java.util.UUID.randomUUID;

public class PublisherAddedEvent {
    private final PublisherResponse book;

    public PublisherAddedEvent(PublisherResponse book) {
        super(randomUUID().toString());
        this.book = book;
    }

    public PublisherResponse getBook() {
        return publisher;
    }
}
