package com.example.order.domain;

import java.util.Objects;

public class Order {
	private final OrderId id;
	private Customer customer;
	private Book book;

	public Order(OrderId id) {
		this.id = id;
		
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

	public OrderId getId() {
		return id;
	}


	public static class Builder {
		private OrderId id;
		private Customer customer;
		private Book book;
		
		
		
		public Builder(OrderId id) {
			this.id = id;
		}
		
		public Builder id(String value) {
			this.id = OrderId.of(value);
			return this;
		}

		public Builder customer(String firstName, String lastName) {
			this.customer = Customer.of(firstName, lastName);
			return this;
		}

		public Builder book(String isbn) {
			this.book = Book.of(isbn);
			return this;
		}


		public Order build() {
			
			var stock = new Order(this.id);
			stock.setCustomer(customer);
			stock.setBook(book);
			return stock;
		}
		
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
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", customer=" + customer + ", book=" + book + "]";
	}
	
	
}
