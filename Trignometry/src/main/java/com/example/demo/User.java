package com.example.demo;

public class User {
	private int id;
	private String name;
	private String phone;
	private String email;
	private String password;
	private String gender;
	private String location;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public User(String name, String phone, String email, String password, String gender, String location) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.location = location;
	}
	
	
}
