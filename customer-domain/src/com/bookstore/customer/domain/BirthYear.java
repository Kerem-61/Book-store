package com.bookstore.customer.domain;



public final class BirthYear {
private final int value;

private BirthYear(int value) {
	this.value = value;
}

public int getValue() {
	return value;
}
public static BirthYear of(int value) {
	return new BirthYear(value);
}

@Override
public String toString() {
	return "BirthYear [value=" + value + "]";
}

}
