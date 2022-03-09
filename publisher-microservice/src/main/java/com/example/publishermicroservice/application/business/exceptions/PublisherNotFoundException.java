package com.example.publishermicroservice.application.business.exceptions;

public class PublisherNotFoundException extends Throwable {
    public PublisherNotFoundException() {
        super("Publisher is not found");
    }

}
