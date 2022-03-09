package com.example.publishermicroservice.config;


import com.example.publishermicroservice.application.PublisherApplication;
import com.example.publishermicroservice.application.business.StandardPublisherApplication;
import com.example.publishermicroservice.repository.PublisherMongoRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;

public class AppConfig {

	@Bean
	public PublisherApplication publisherApp(PublisherMongoRepository publisherMongoRepository,
											 ApplicationEventPublisher eventPublisher) {
		return new StandardPublisherApplication(publisherMongoRepository, eventPublisher);
	}
}
