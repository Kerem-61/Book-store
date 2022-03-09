package com.bookstore.domain;

public class Publisher {
	
	private final String publisherId;

	public Publisher(String publisherId) {
		super();
		this.publisherId = publisherId;
	}

	public String getPublisherId() {
		return publisherId;
	}

	 public static Publisher of(String value) {
	        if (!isValid(value))
	            throw new IllegalArgumentException("This is not a valid id");
	        return new Publisher(value);
	    }

	    private static boolean isValid(String value) {
	        return value.matches("^[a-z0-9A-Z]{10,20}$");
	    }
	
	@Override
	public String toString() {
		return "Publisher [publisherId=" + publisherId + "]";
	}
	
	
}
