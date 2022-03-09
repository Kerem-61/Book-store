package com.bookstore.dto.response;

import java.util.List;

import com.bookstore.customer.domain.Interest;

public class UpdateCustomerResponse {

	private String fullname;
	private String birthYear;
	private List<String> locations;
	private List<Interest> interests;
	private String email;
	private double epurse;
	private String password;
	private Boolean isAdmin;

	public UpdateCustomerResponse() {

	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public List<String> getLocations() {
		return locations;
	}

	public void setLocations(List<String> locations) {
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
		return "UpdateCustomerResponce [ fullname=" + fullname + ", birthYear=" + birthYear + ", locations=" + locations
				+ ", interests=" + interests + ", email=" + email + ", epurse=" + epurse + ", password=" + password
				+ ", isAdmin=" + isAdmin + "]";
	}

}
