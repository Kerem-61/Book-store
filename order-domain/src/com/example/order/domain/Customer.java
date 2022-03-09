package com.example.order.domain;

import java.util.Objects;

public final class Customer {
	
	private final String firstName;
	private final String lastName;
	
	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public static Customer of(String firstName, String lastName) {
		Objects.requireNonNull(firstName);
		Objects.requireNonNull(lastName);
		if(firstName.length()<2|| lastName.length()<2)
			throw new IllegalArgumentException("Firstname and lastname should be at least two character");
		return new Customer(firstName, lastName);
				

	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	

	
}
