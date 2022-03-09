package com.bookstore.book.domain;

import java.util.List;
import java.util.Objects;

public class Category {
	
	private final String id;
	private final String name;
	private final List<subCategory> subCategory;

	
	
	public Category(String id, String name) {
		this.id = id;
		this.name = name;
		this.subCategory = getSubCategory();
	}
	
	public static Category of(String id, String name) {
		Objects.requireNonNull(name);
		if (name.length() < 2 )
			throw new IllegalArgumentException("Category name should have at least two characters");	
		return new Category(id, name);
	}


	public String getName() {
		return name;
	}


	public String getId() {
		return id;
	}

	public List<subCategory> getSubCategory() {
		return subCategory;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", subCategory=" + getSubCategory() + "]";
	}

	

}
