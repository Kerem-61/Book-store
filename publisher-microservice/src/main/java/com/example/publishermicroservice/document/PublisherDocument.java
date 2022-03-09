package com.example.publishermicroservice.document;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection="publishers")
public class PublisherDocument {
	
	@Id
	private String publisherId;
	private String logo;
	private String name;
	private String requistion;

	public PublisherDocument() {
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

	@Override
	public String toString() {
		return "PublisherDocument{" +
				"publisherId='" + publisherId + '\'' +
				", logo='" + logo + '\'' +
				", name='" + name + '\'' +
				", requistion='" + requistion + '\'' +
				'}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(publisherId, logo, name, requistion);
	}
}
