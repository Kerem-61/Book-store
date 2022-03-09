package com.bookstore.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bookstore.dto.response.RemoveStockResponse;
import com.bookstore.dto.response.SaveStockResponse;
import com.bookstore.dto.response.StockResponse;
import com.bookstore.stock.domain.Stock;

@Configuration
public class ModelMapperConfig {
	private static final Converter<Stock, StockResponse> STOCK_TO_STOCK_RESPONSE_CONVERTER = (context) -> {
		var stock = context.getSource();
		var response = new StockResponse();

		response.setIsbn(stock.getIsbn().getValue());
		response.setSellNumber(stock.getNumberOfBooksSold().getValue());
		response.setSku(stock.getSku().getValue());
		response.setStockNumber(stock.getNumberOfBooksLeft().getValue());
		System.err.println("STOCK_TO_STOCK_RESPONSE_CONVERTER" + response);
		return response;
	};

	private static final Converter<Stock, RemoveStockResponse> STOCK_TO_REMOVE_STOCK_RESPONSE_CONVERTER = (context) -> {
		var stock = context.getSource();
		var response = new RemoveStockResponse();

		response.setIsbn(stock.getIsbn().getValue());
		response.setSellNumber(stock.getNumberOfBooksSold().getValue());
		response.setSku(stock.getSku().getValue());
		response.setStockNumber(stock.getNumberOfBooksLeft().getValue());

		return response;
	};

	private static final Converter<Stock, SaveStockResponse> STOCK_TO_SAVE_STOCK_RESPONSE_CONVERTER = (context) -> {
		var stock = context.getSource();
		var response = new SaveStockResponse();

		response.setIsbn(stock.getIsbn().getValue());
		response.setSellNumber(stock.getNumberOfBooksSold().getValue());
		response.setSku(stock.getSku().getValue());
		response.setStockNumber(stock.getNumberOfBooksLeft().getValue());

		return response;
	};

	@Bean
	public ModelMapper modelMapper() {
		var mapper = new ModelMapper();
		mapper.addConverter(STOCK_TO_STOCK_RESPONSE_CONVERTER, Stock.class, StockResponse.class);
		mapper.addConverter(STOCK_TO_REMOVE_STOCK_RESPONSE_CONVERTER, Stock.class, RemoveStockResponse.class);
		mapper.addConverter(STOCK_TO_SAVE_STOCK_RESPONSE_CONVERTER, Stock.class, SaveStockResponse.class);

		return mapper;
	}

}
