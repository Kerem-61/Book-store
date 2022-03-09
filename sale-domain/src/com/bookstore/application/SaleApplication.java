package com.bookstore.application;

import java.util.Optional;

import com.bookstore.domain.Sale;
import com.bookstore.domain.SaleId;

public interface SaleApplication {
	 

	Optional<Sale> findBySaleId(SaleId saleId);
	Sale saveSale(Sale sale);
	
}
