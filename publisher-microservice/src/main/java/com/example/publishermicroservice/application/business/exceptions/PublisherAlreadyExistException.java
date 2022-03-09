package com.example.publishermicroservice.application.business.exceptions;

public class PublisherAlreadyExistException extends  Throwable{
    public PublisherAlreadyExistException() {
        super("Publisher already exist");
    }

}
