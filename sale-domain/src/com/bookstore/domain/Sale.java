package com.bookstore.domain;

import java.util.Objects;

public class Sale {

	private SaleId id;
	private Customer customer;
	private Book book;

	
	
	public static class Builder {
		private SaleId id;
		private Customer customer;
		private Book book;


		public Builder id(String value) {
			this.id = SaleId.of(value);
			return this;
		}

		public Builder customer(String value) {
			this.customer = Customer.valueOf(value);
			return this;
		}

		public Builder book(String isbn) {
			this.book = Book.of(isbn);
			return this;
		}

		public Sale build() {

			var sale = new Sale(this.id);
			sale.setCustomer(customer);
			sale.setBook(book);
			return sale;
		}
	}

	public Sale(SaleId id) {

		this.id = id;
	}

	public SaleId getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Sale [id=" + id + ", customer=" + customer + ", book=" + book + "]";
	}
	

}
