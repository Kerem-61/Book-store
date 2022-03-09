package com.bookstore.book.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Book {

	private Isbn isbn;
	private Title title;
	private Author author;
	private Publisher publisher;
	private Edition edition;
	private PublicationYear publication;
	private Price price;
	private Reviews reviews;
	private Contents contents;
	private Photo photo;
	private List<Popularity> popularity;
	private Category category;

	public static class Builder {
		private Isbn isbn;
		private Title title;
		private Author author;
		private Publisher publisher;
		private Edition edition;
		private PublicationYear publication;
		private Price price;
		private Reviews reviews;
		private Contents contents;
		private Photo photo;
		private List<Popularity> popularity;
		private Category category;

		public Builder isbn(String value) {
			this.isbn = Isbn.valueOf(value);
			return this;
		}

		public Builder title(String name) {
			this.title = Title.of(name);
			return this;
		}

		public Builder author(String first, String last) {
			this.author = Author.of(first, last);
			return this;
		}

		public Builder publisher(String name) {
			return publisher(name);
		}

		public Builder edition(String value) {
			return edition(value);
		}

		public Builder publication(int value) {
			return publication(value);
		}

		public Builder price(double price, FiatCurrency currency) {
			this.price = Price.of(price, currency);
			return this;
		}

		public Builder reviews(int value) {
			return reviews(value);
		}

		public Builder contents(String text) {
			this.contents = Contents.of(text);
			return this;
		}

		public Builder photo(byte[] values) {
			this.photo = Photo.valueOf(values);
			return this;
		}

		public Builder popularity(String... value) {
			this.popularity = Arrays.stream(value).filter(Objects::nonNull).map(String::toUpperCase)
					.map(Popularity::valueOf).toList();
			return this;
		}

		public Builder category(String id, String name) {
			this.category = Category.of(id, name);
			return this;
		}

		public Book build() {

			var book = new Book(this.isbn);
			book.setIsbn(isbn);
			book.setTitle(title);
			book.setAuthor(author);
			book.setCoverPhoto(photo);
			book.setPublisher(publisher);
			book.setEdition(edition);
			book.setPublication(publication);
			book.setPrice(price);
			book.setReviews(reviews);
			book.setContents(contents);
			book.setPopularity(popularity);
			book.setCategory(category);
			return book;
		}

	}

	public Book(Isbn isbn) {
		this.isbn = isbn;
	}

	public Isbn getIsbn() {
		return isbn;
	}

	public void setIsbn(Isbn isbn) {
		this.isbn = isbn;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Edition getEdition() {
		return edition;
	}

	public void setEdition(Edition edition) {
		this.edition = edition;
	}

	public PublicationYear getPublication() {
		return publication;
	}

	public void setPublication(PublicationYear publication) {
		this.publication = publication;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Reviews getReviews() {
		return reviews;
	}

	public void setReviews(Reviews reviews) {
		this.reviews = reviews;
	}

	public Contents getContents() {
		return contents;
	}

	public void setContents(Contents contents) {
		this.contents = contents;
	}

	public Photo getCoverPhoto() {
		return photo;
	}

	public void setCoverPhoto(Photo photo) {
		this.photo = photo;
	}

	public List<Popularity> getPopularity() {
		return popularity;
	}

	public void setPopularity(List<Popularity> popularity) {
		this.popularity = popularity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(isbn, other.isbn);
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", edition=" + edition + ", publication=" + publication + ", price=" + price + ", reviews=" + reviews
				+ ", contents=" + contents + ", coverPhoto=" + photo + ", popularity=" + popularity + ", category="
				+ category + "]";
	}

}
