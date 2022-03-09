package com.bookstore.dto.response;

public class RemoveCustomerResponse {

	private String fullname;
	private String email;
	private Boolean isAdmin;

	public RemoveCustomerResponse() {

	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RemoveCustomerResponse(String fullname, String email, Boolean isAdmin) {

		this.fullname = fullname;
		this.email = email;
		this.isAdmin = isAdmin;
	}

}
