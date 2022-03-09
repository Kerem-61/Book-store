package com.bookstore.domain;

import java.util.Objects;

public class Requistion {
	private Isbn isbn;
	private RequistionId requistionId;
	private Publisher publisher;

	public static class Builder {
		private Isbn isbn;
		private RequistionId requistionId;
		private Publisher publisher;

		public Builder isbn(String value) {
			this.isbn = Isbn.of(value);
			return this;
		}

		public Builder requistionId(String value) {
			this.requistionId = RequistionId.of(value);
			return this;
		}

		public Builder publisher(String value) {
			this.publisher = Publisher.of(value);
			return this;
		}

		public Requistion build() {

			var requistion = new Requistion(this.requistionId);
			requistion.setIsbn(isbn);
			requistion.setPublisher(publisher);
			requistion.setRequistionId(requistionId);
			return requistion;
		}

	}

	public Requistion(RequistionId requistionId) {
		this.requistionId = requistionId;
	}

	public Isbn getIsbn() {
		return isbn;
	}

	public void setIsbn(Isbn isbn) {
		this.isbn = isbn;
	}

	public RequistionId getRequistionId() {
		return requistionId;
	}

	public void setRequistionId(RequistionId requistionId) {
		this.requistionId = requistionId;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(requistionId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Requistion other = (Requistion) obj;
		return Objects.equals(requistionId, other.requistionId);
	}

	@Override
	public String toString() {
		return "Requistion [isbn=" + isbn + ", requistionId=" + requistionId + ", publisher=" + publisher + "]";
	}

}