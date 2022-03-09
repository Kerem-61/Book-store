package com.example.publishermicroservice.application;

import com.example.publishermicroservice.dto.response.AddPublisherResponse;
import com.example.publishermicroservice.dto.response.PublisherResponse;

import java.util.List;

public interface PublisherApplication {

    PublisherResponse findPublisherById(String isbn);

    List<PublisherResponse> findPublishers(int page, int size);

    AddPublisherResponse addPublisher(AddPublisherResponse request);
}
