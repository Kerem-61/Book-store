package com.bookstore.application;

import com.bookstore.dto.request.SaveStockRequest;
import com.bookstore.dto.response.RemoveStockResponse;
import com.bookstore.dto.response.SaveStockResponse;
import com.bookstore.dto.response.StockResponse;

public interface StockApplication {
	StockResponse findStockByIsbn(String isbn);

	SaveStockResponse saveStock(SaveStockRequest request);

	RemoveStockResponse removeStock(String isbn);
}
