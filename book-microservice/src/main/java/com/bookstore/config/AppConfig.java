package com.bookstore.config;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;

import com.bookstore.application.BookApplication;
import com.bookstore.application.business.StandardBookApplication;
import com.bookstore.repository.BookMongoRepository;

public class AppConfig {

	@Bean
	public BookApplication hrApp(BookMongoRepository bookMongoRepository, 
			ApplicationEventPublisher eventPublisher) {
		return new StandardBookApplication(bookMongoRepository, eventPublisher);
	}
}
