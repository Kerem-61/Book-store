package com.bookstore.application.business;

import com.bookstore.application.RequistionApplication;
import com.bookstore.domain.Isbn;
import com.bookstore.domain.Requistion;
import com.bookstore.order.infra.EventPublisher;
import com.bookstore.repository.RequistionRepository;

public class StandardRequistionApplication implements RequistionApplication {

	RequistionRepository requistionRepository;
	EventPublisher eventPublisher;
	
	
	public StandardRequistionApplication(RequistionRepository requistionRepository, EventPublisher eventPublisher) {
		this.requistionRepository = requistionRepository;
		this.eventPublisher = eventPublisher;
	}


	@Override
	public Requistion findRequistionByIsbn(Isbn isbn) {
		return requistionRepository.findRequistionByIsbn(isbn);
	}


		

}
