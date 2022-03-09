package com.bookstore.config;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;

import com.bookstore.application.StockApplication;
import com.bookstore.application.business.StandardStockApplication;
import com.bookstore.repository.StockMongoRepository;

public class AppConfig {
	@Bean
	public StockApplication hrApp(StockMongoRepository stockMongoRepository, 
			ApplicationEventPublisher eventPublisher) {
		return new StandardStockApplication(stockMongoRepository, eventPublisher);
	}
}
