package com.bookstore.dto.response;

import java.util.List;

import com.bookstore.customer.domain.Adress;
import com.bookstore.customer.domain.Interest;

public class CustomerResponse {

	private String fullname;
	private int birthYear;
	private List<Adress> locations;
	private List<Interest> interests;
	private String email;
	private double epurse;
	private String password;
	private Boolean isAdmin;

	public CustomerResponse() {

	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public List<Adress> getLocations() {
		return locations;
	}

	public void setLocations(List<Adress> locations) {
		this.locations = locations;
	}

	public List<Interest> getInterests() {
		return interests;
	}

	public void setInterests(List<Interest> interests) {
		this.interests = interests;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getEpurse() {
		return epurse;
	}

	public void setEpurse(double epurse) {
		this.epurse = epurse;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "CustomerResponse [fullname=" + fullname + ", birthYear=" + birthYear + ", locations=" + locations
				+ ", interests=" + interests + ", email=" + email + ", epurse=" + epurse + ", password=" + password
				+ ", isAdmin=" + isAdmin + "]";
	}

	
}
