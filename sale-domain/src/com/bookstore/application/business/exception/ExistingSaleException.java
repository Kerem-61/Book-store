package com.bookstore.application.business.exception;

import com.bookstore.domain.SaleId;


@SuppressWarnings("serial")
public class ExistingSaleException extends RuntimeException {
	private SaleId saleId;
		

		public ExistingSaleException(String message, SaleId saleId) {
			super(message);
			this.saleId = saleId;
		}


		public SaleId getOrderId() {
			return saleId;
		}


		
}
