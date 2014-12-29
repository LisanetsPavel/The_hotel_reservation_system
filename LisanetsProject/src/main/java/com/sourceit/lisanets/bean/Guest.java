package com.sourceit.lisanets.bean;

public class Guest {
	private int idGuest;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String password;

	@Override
	public String toString() {
		return "Guest [id_guest=" + idGuest + ", first_name=" + firstName
				+ ", last_name=" + lastName + ", phone=" + phone + ", email="
				+ email + ", password=" + password + "]";
	}

	public int getIdGuest() {
		return idGuest;
	}

	public void setIdGuest(int id_guest) {
		this.idGuest = id_guest;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
