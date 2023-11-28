package com.action.elements.to;

/**
 * Transfer Object mapped into actionElements.jsp form attributes.
 */
public class User {
	private String fname;
	private int age;
	private String email;
	private String password;
	private String gender;
	private String hobby;
	private String country;
	
	public User() {

	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "User [fname=" + fname + ", age=" + age + ", email=" + email + ", password=" + password + ", gender="
				+ gender + ", hobby=" + hobby + ", country=" + country + "]";
	}
}
