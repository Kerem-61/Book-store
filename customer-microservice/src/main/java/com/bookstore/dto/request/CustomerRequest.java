package com.bookstore.dto.request;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;

import com.bookstore.customer.domain.Adress;
import com.bookstore.customer.domain.Interest;
import com.bookstore.validation.StrongPassword;

public class CustomerRequest {
	
	@Email
	private String email;
	@NotBlank
	private String firstName;
	private String lastName;
	private int birthYear;
	@NotBlank
	private List<String> locations;
	private String interests;
	@Min(1)
	private double epurse;
	@StrongPassword
	@NotBlank
	private String password;
	@NotBlank
	private Boolean isAdmin;
	
	
	public CustomerRequest() {
		
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public int getBirthYear() {
		return birthYear;
	}


	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
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
		return "CustomerRequest [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthYear=" + birthYear + ", locations=" + locations + ", interests=" + interests + ", epurse="
				+ epurse + ", password=" + password + ", isAdmin=" + isAdmin + "]";
	}


	


	
	
	
}
