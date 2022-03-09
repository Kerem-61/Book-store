package com.bookstore.customer.domain;

public final class IsAdmin {
	private final boolean value;

	private IsAdmin(boolean value) {
	
		this.value = value;
	}

	public boolean isAdmin() {
		return value;
	}
	/*
	 * kayıt formu
	 * bilgiler
	 * validation
	 * kitap arama
	 * sipariş verme
	 * admin gözüyle nelere bakılır
	 * publisher gözüyle bak
	 * */
	public static IsAdmin of(boolean value) {
		return new IsAdmin(value);
	}
	@Override
	public String toString() {
		return "IsAdmin [value=" + value + "]";
	}
	
	
}
