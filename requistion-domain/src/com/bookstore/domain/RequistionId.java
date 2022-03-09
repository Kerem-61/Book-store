package com.bookstore.domain;

import java.util.Objects;

public class RequistionId {
	 private final String id;

	    public RequistionId(String id) {
	        this.id = id;
	    }

	    public static RequistionId of(String value) {
	        if (!isValid(value))
	            throw new IllegalArgumentException("This is not a valid id");
	        return new RequistionId(value);
	    }

	    private static boolean isValid(String value) {
	        return value.matches("^[a-z0-9A-Z]{10,20}$");
	    }
	    @Override
	    public int hashCode() {
	        return Objects.hash(id);
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        RequistionId that = (RequistionId) o;
	        return Objects.equals(id, that.id);
	    }

	    @Override
	    public String toString() {
	        return "PublisherId{" +
	                "id='" + id + '\'' +
	                '}';
	    }
}
