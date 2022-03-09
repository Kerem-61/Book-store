package com.bookstore.repository;

import java.util.Optional;

import com.bookstore.domain.Sale;
import com.bookstore.domain.SaleId;


public interface SaleRepository {
	
	Optional<Sale> findBySaleId(SaleId saleId);
	Sale saveSale(Sale sale);
	boolean existById(SaleId saleId);
}
