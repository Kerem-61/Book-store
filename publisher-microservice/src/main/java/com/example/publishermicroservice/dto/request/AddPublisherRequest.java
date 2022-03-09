package com.example.publishermicroservice.dto.request;


import com.mongodb.lang.NonNull;

import java.util.Objects;

public class AddPublisherRequest {
	
	@NotBlank
	private String isbn;
	private String publisherId;
	@NotBlank
	private String logo;
	@NotBlank
	private String name;
	@NotBlank
	private String requistion;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRequistion() {
		return requistion;
	}

	public void setRequistion(String requistion) {
		this.requistion = requistion;
	}

	public AddPublisherRequest() {
	}

	@Override
	public String toString() {
		return "AddPublisherRequest{" +
				"isbn='" + isbn + '\'' +
				", publisherId='" + publisherId + '\'' +
				", logo='" + logo + '\'' +
				", name='" + name + '\'' +
				", requistion='" + requistion + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AddPublisherRequest that = (AddPublisherRequest) o;
		return isbn.equals(that.isbn) && publisherId.equals(that.publisherId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn, publisherId);
	}
}
