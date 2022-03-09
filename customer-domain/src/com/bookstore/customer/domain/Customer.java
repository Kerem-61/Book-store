package com.bookstore.customer.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;



public class Customer {

	private FullName fullname;
	private BirthYear birthYear;
	private List<Adress> locations;
	private List<Interest> interests;
	private Email email;
	private Epurse epurse;
	
	private StrongPassword password;
	private IsAdmin isAdmin;
	
	public static class Builder {
	
		private FullName fullname;
		private BirthYear birthYear;
		private List<Adress> locations;
		private List<Interest> interests;
		private Email email;
		private Epurse epurse;
		
		private StrongPassword password;
		private IsAdmin isAdmin;
		
		
		public Builder fullname(String first, String last) {
			this.fullname=FullName.of(first, last);
			return this;
		}
		public Builder birthYear(int value) {
			this.birthYear=BirthYear.of(value);
			return this;
		}
		public Builder email(String value) {
			this.email=Email.of(value);
			return this;
		}
		public Builder epurse(int value) {
			this.epurse=Epurse.of(value);
			return this;
		}
	
		public Builder password(String value) {
			this.password=StrongPassword.of(value);
			return this;
		}
		public Builder isAdmin(boolean value) {
			this.isAdmin=IsAdmin.of(value);
			return this;
		}
		public Builder interests(String...interest) {
			this.interests=Arrays.stream(interest).filter(Objects::nonNull).map(String::toUpperCase).map(Interest::valueOf).toList();
			return this;
		}
		public Builder locations(String city, String district, String street, String number) {
			this.locations.add(Adress.of(city, district, street, number));
			return this;
		}
		public Customer build() {
			//validation
			var customer= new Customer(this.email);
			customer.setFullname(fullname);
			customer.setBirthYear(birthYear);
			customer.setEmail(email);
			customer.setEpurse(epurse);
			customer.setPassword(password);
			customer.setIsAdmin(isAdmin);
			customer.setInterests(interests);
			
			
			return customer;
		}
	}
	
	

	public Customer(Email email) {
	
		this.email = email;
	}

	public FullName getFullname() {
		return fullname;
	}
	
	public void setFullname(FullName fullname) {
		this.fullname = fullname;
	}
	public BirthYear getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(BirthYear birthYear) {
		this.birthYear = birthYear;
	}
	
	public void setLocation(List<Adress> location) {
		this.locations = location;
	}
	public List<Adress> getLocation() {
		return locations;
	}
	
	public Email getEmail() {
		return email;
	}
	public void setEmail(Email email) {
		this.email = email;
	}
	public Epurse getEpurse() {
		return epurse;
	}
	public void setEpurse(Epurse epurse) {
		this.epurse = epurse;
	}
	
	public StrongPassword getPassword() {
		return password;
	}
	public void setPassword(StrongPassword password) {
		this.password = password;
	}
	
	public IsAdmin getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(IsAdmin isAdmin) {
		this.isAdmin = isAdmin;
	}

	public List<Interest> getInterests() {
		return interests;
	}
	public void setInterests(List<Interest> interests) {
		this.interests = interests;
	}
	@Override
	public String toString() {
		return "Customer [  fullname=" + fullname + ", birthYear=" + birthYear + ", location=" + locations
				+ ", email=" + email + ", epurse=" + epurse +  ", password=" + password
				+ ", isAdmin=" + isAdmin + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(email);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(email, other.email);
	}
	
	
	
	
	
	
	
}
