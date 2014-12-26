package com.sourceit.lisanets.bean;

public class Guest {
	private int id_guest;
	private String first_name;
	private String last_name;
	private String phone;
	private String email;
	private String password;

	
	

	@Override
	public String toString() {
		return "Guest [id_guest=" + id_guest + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", phone=" + phone + ", email="
				+ email + ", password=" + password + "]";
	}



	public int getId_guest() {
		return id_guest;
	}

	public void setId_guest(int id_guest) {
		this.id_guest = id_guest;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
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
