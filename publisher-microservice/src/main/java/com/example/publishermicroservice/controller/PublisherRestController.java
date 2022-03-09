package com.example.publishermicroservice.controller;


import com.example.publishermicroservice.application.business.exceptions.PublisherNotFoundException;
import com.example.publishermicroservice.dto.response.AddPublisherResponse;
import com.example.publishermicroservice.dto.response.PublisherResponse;
import com.example.publishermicroservice.service.PublisherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestScope
@RequestMapping("publishers")
@CrossOrigin
@Validated
@Api( tags = "Publishers")
public class PublisherRestController {

	private PublisherService publisherService;


	public PublisherRestController(PublisherService publisherService) {
		this.publisherService = publisherService;
	}

	@GetMapping("{isbn}")
	@ApiOperation(value = "This method is used to get the book for the given {isbn}")
	public PublisherResponse getPublisherByIsbn(
			@PathVariable String id) throws PublisherNotFoundException {
		return publisherService.findPublisherById( id);
	}
	
	@PostMapping
	public AddPublisherResponse addBook(
			@RequestBody @Validated AddPublisherResponse request) {
		return publisherService.addPublisher(request);
	}


}
