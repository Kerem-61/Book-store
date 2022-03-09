package com.bookstore.config;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bookstore.application.CustomerApplication;
import com.bookstore.application.business.StandardCustomerApplication;
import com.bookstore.repository.CustomerMongoRepository;

@Configuration
public class AppConfig {

	@Bean
	public CustomerApplication hrApp(CustomerMongoRepository customerMongoRepository, 
			ApplicationEventPublisher eventPublisher) {
		return new StandardCustomerApplication(customerMongoRepository, eventPublisher);
	}
}
