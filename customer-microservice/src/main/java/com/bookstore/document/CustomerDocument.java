package com.bookstore.document;

import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bookstore.customer.domain.Adress;
import com.bookstore.customer.domain.Interest;

@Document(collection="customers")
public class CustomerDocument {
	
	@Id
	private String id;
	private String fullname;
	private int birthYear;
	private List<Adress> locations;
	private List<Interest> interests;
	private String email;
	private double epurse;
	
	private String password;
	private Boolean isAdmin;
	
	public CustomerDocument() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		CustomerDocument other = (CustomerDocument) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "CustomerDocument [id=" + id + ", fullname=" + fullname + ", birthYear=" + birthYear + ", locations="
				+ locations + ", interests=" + interests + ", email=" + email + ", epurse=" + epurse + ", password="
				+ password + ", isAdmin=" + isAdmin + "]";
	}
	
	
	
	

}
