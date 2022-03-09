package com.bookstore.application.business;

import java.util.Optional;

import com.bookstore.application.SaleApplication;
import com.bookstore.application.business.events.SaleSavedEvent;
import com.bookstore.application.business.exception.ExistingSaleException;
import com.bookstore.domain.Sale;
import com.bookstore.domain.SaleId;
import com.bookstore.order.infra.EventPublisher;
import com.bookstore.repository.SaleRepository;

public class StandardSaleApplication implements SaleApplication {

	SaleRepository saleRepository;
	EventPublisher eventPublisher;
	

	public StandardSaleApplication(SaleRepository saleRepository, EventPublisher eventPublisher) {
		this.saleRepository = saleRepository;
		this.eventPublisher = eventPublisher;
	}

	

	@Override
	public Sale saveSale(Sale sale) {
		var value = sale.getId();
		if (saleRepository.existById(value))
			throw new ExistingSaleException("Sale already exist", sale.getId());
		Sale saveSale = saleRepository.saveSale(sale);
		var businessEvent = new SaleSavedEvent(saveSale);
		eventPublisher.publishEvent(businessEvent);
		return saveSale;
		
	}



	@Override
	public Optional<Sale> findBySaleId(SaleId saleId) {
		return saleRepository.findBySaleId(saleId);
	}

}
