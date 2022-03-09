package com.bookstore.dto.request;

import javax.validation.constraints.NotBlank;

import com.bookstore.validation.Isbn;

public class RemoveStockRequest {
	@Isbn
	private String isbn;
	@NotBlank
	private int sellNumber;
	@NotBlank
	private String sku;
	@NotBlank
	private int stockNumber;

	public RemoveStockRequest() {
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
		return "RemoveStockRequest [isbn=" + isbn + ", sellNumber=" + sellNumber + ", sku=" + sku + ", stockNumber="
				+ stockNumber + "]";
	}

}
