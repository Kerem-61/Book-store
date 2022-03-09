package com.example.publishermicroservice.dto.response;


import com.example.publishermicroservice.dto.request.AddPublisherRequest;

import java.util.Objects;

public class AddPublisherResponse {
	private String identity;
	private String publisher;
	private String logo;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	private String isbn;

	AddPublisherRequest request;
	public AddPublisherResponse() {
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public AddPublisherRequest getRequest() {
		return request;
	}

	public void setRequest(AddPublisherRequest request) {
		this.request = request;
	}

	@Override
	public String toString() {
		return "AddPublisherResponse{" +
				"identity='" + identity + '\'' +
				", publisher='" + publisher + '\'' +
				", logo='" + logo + '\'' +
				", request=" + request +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AddPublisherResponse that = (AddPublisherResponse) o;
		return Objects.equals(identity, that.identity);
	}

	@Override
	public int hashCode() {
		return Objects.hash(identity);
	}

}
