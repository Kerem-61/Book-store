package com.bookstore.application.business.events;

import com.bookstore.domain.Sale;

public class SaleSavedEvent extends SaleEvent{
	private Sale sale;

	public Sale getSale() {
		return sale;
	}

	
	public SaleSavedEvent(Sale sale) {
		this.sale = sale;
	}
	

}
