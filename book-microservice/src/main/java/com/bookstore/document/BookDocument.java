package com.bookstore.document;

import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bookstore.book.domain.FiatCurrency;

@Document(collection="books")
public class BookDocument {
	
	@Id
	private String identity;
	private String title;
	private String author;
	private String publisher;
	private String edition;
	private int publication;
	private double price;
	private FiatCurrency fiatCurrency;
	private int reviews;
	private String contents;
	private String photo;
	private List<String> popularity;
	private String category;
	
	public BookDocument() {
	}

	public FiatCurrency getFiatCurrency() {
		return fiatCurrency;
	}

	public void setFiatCurrency(FiatCurrency fiatCurrency) {
		this.fiatCurrency = fiatCurrency;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public int getPublication() {
		return publication;
	}

	public void setPublication(int publication) {
		this.publication = publication;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getReviews() {
		return reviews;
	}

	public void setReviews(int reviews) {
		this.reviews = reviews;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<String> getPopularity() {
		return popularity;
	}

	public void setPopularity(List<String> popularity) {
		this.popularity = popularity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookDocument other = (BookDocument) obj;
		return Objects.equals(identity, other.identity);
	}

	@Override
	public String toString() {
		return "BookDocument [identity=" + identity + ", title=" + title + ", author=" + author + ", publisher="
				+ publisher + ", edition=" + edition + ", publication=" + publication + ", price=" + price
				+ ", reviews=" + reviews + ", contents=" + contents + ", photo=" + photo + ", popularity=" + popularity
				+ ", category=" + category + "]";
	}
	
	
	
	
}
