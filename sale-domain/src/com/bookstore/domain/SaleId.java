package com.bookstore.domain;

import java.util.Objects;



public class SaleId {
	private final String value;

	private SaleId(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static SaleId of(String value) {
		if (!isValid(value))
			throw new IllegalArgumentException("This is not a valid id");
		return new SaleId(value);
	}

	private static boolean isValid(String value) {
		return value.matches("^[a-z0-9A-Z]{10,20}$");
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaleId other = (SaleId) obj;
		return Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "SaleId [value=" + value + "]";
	}
}
