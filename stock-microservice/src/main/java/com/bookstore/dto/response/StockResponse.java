package com.bookstore.dto.response;

public class StockResponse {
	private String isbn;
	private int sellNumber;
	private String sku;
	private int stockNumber;

	public StockResponse() {
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getSellNumber() {
		return sellNumber;
	}

	public void setSellNumber(int sellNumber) {
		this.sellNumber = sellNumber;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
	}

	@Override
	public String toString() {
		return "StockResponse [isbn=" + isbn + ", sellNumber=" + sellNumber + ", sku=" + sku + ", stockNumber="
				+ stockNumber + "]";
	}

}
