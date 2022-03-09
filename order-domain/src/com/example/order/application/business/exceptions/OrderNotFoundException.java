package com.example.order.application.business.exceptions;

@SuppressWarnings("serial")
public class OrderNotFoundException extends RuntimeException {
	
	
	private final String identity;
	

	public OrderNotFoundException(String identity, String string) {
		
		this.identity = identity;
	}


	public String getIdentity() {
		return identity;
	}
	
	

}
