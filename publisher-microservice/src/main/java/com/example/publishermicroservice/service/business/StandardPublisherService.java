package com.example.publishermicroservice.service.business;


import com.example.publishermicroservice.application.PublisherApplication;
import com.example.publishermicroservice.application.business.exceptions.PublisherNotFoundException;
import com.example.publishermicroservice.dto.response.AddPublisherResponse;
import com.example.publishermicroservice.dto.response.PublisherResponse;
import com.example.publishermicroservice.service.PublisherService;
import org.modelmapper.ModelMapper;

public class StandardPublisherService implements PublisherService {
	private PublisherApplication publisherApplication;
	private ModelMapper modelMapper;

	public StandardPublisherService(PublisherApplication publisherApplication, ModelMapper modelMapper) {
		this.publisherApplication = publisherApplication;
		this.modelMapper = modelMapper;
	}

	@Override
	public PublisherResponse findPublisherById(String id) throws PublisherNotFoundException {
		var publisher = publisherApplication.findPublisherById(String.valueOf(id));
		if (publisher.getPublisherId().isEmpty())
			throw new PublisherNotFoundException();
		return modelMapper.map(publisher.getName(), PublisherResponse.class);
	}

	@Override
	public AddPublisherResponse addPublisher(AddPublisherResponse request) {
		var addedPublisher = publisherApplication.addPublisher(request);
		return modelMapper.map(addedPublisher, AddPublisherResponse.class);

	}




}
