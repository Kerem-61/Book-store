package com.bookstore.dto.request;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.bookstore.customer.domain.Interest;
import com.bookstore.validation.StrongPassword;

public class UpdateCustomerRequest {

	@NotBlank
	private String email;
	private List<String> locations;
	private String interests;
	@Min(1)
	private double epurse;
	@StrongPassword
	private String password;
	@NotBlank
	private Boolean isAdmin;
	
	public UpdateCustomerRequest() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getLocations() {
		return locations;
	}

	public void setLocations(List<String> locations) {
		this.locations = locations;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
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
		return "UpdateCustomerRequest [email=" + email + ", locations=" + locations + ", interests=" + interests
				+ ", epurse=" + epurse + ", password=" + password + ", isAdmin=" + isAdmin + "]";
	}
	
	
	
	
	
	
}
