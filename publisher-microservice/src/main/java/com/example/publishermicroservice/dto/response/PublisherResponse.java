package com.example.publishermicroservice.dto.response;



public class PublisherResponse {
	private String publisherId;
	private String name;
	private String requistion;
	private String publisher;
	private String logo;

	public PublisherResponse() {
	}

	public String getPublisherId() {
		return publisherId;
	}

	public String getName() {
		return name;
	}

	public String getRequistion() {
		return requistion;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getLogo() {
		return logo;
	}

	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRequistion(String requistion) {
		this.requistion = requistion;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
}
