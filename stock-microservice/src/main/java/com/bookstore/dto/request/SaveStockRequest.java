package com.bookstore.dto.request;

import javax.validation.constraints.NotBlank;

import com.bookstore.validation.Isbn;

public class SaveStockRequest {
	@Isbn
	private int identity;
	@NotBlank
	private String isbn;
	@NotBlank
	private int sellNumber;
	@NotBlank
	private String sku;
	@NotBlank
	private int stockNumber;

	public SaveStockRequest() {
	}

	public String getIsbn() {
		return isbn;
	}

	public int getIdentity() {
		return identity;
	}

	public void setIdentity(int identity) {
		this.identity = identity;
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
		return "SaveStockRequest [isbn=" + isbn + ", sellNumber=" + sellNumber + ", sku=" + sku + ", stockNumber="
				+ stockNumber + "]";
	}

}
