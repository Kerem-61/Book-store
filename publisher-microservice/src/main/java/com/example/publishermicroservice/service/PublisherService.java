package com.example.publishermicroservice.service;


import com.example.publishermicroservice.application.business.exceptions.PublisherNotFoundException;
import com.example.publishermicroservice.dto.response.AddPublisherResponse;
import com.example.publishermicroservice.dto.response.PublisherResponse;

public interface PublisherService {
	
	PublisherResponse findPublisherById(String isbn) throws PublisherNotFoundException;

	AddPublisherResponse addPublisher(AddPublisherResponse request);



}
