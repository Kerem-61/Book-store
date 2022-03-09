package com.bookstore.customer.domain;

import java.util.Objects;

public final class Adress {
	private final String city;
	private final String district;
	private final String street;
	private final String number;
	
	private Adress(String city, String district, String street, String number) {
		this.city = city;
		this.district = district;
		this.street = street;
		this.number = number;
	}
	
	public static Adress of(String city, String district, String street, String number) {
		Objects.requireNonNull(city);
		Objects.requireNonNull(district);
		Objects.requireNonNull(street);
		Objects.requireNonNull(number);
		return new Adress( city,district,street,number);
				

	}

	public String getCity() {
		return city;
	}

	public String getDistrict() {
		return district;
	}

	public String getStreet() {
		return street;
	}

	public String getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "Adress [city=" + city + ", district=" + district + ", street=" + street + ", number=" + number + "]";
	}
	
}
