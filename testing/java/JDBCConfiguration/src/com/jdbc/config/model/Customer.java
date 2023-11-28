package com.jdbc.config.model;

/**
  create table Customer (
  	cid int primaty key auto_increment, 
  	name varchar(256),
  	phone varchar(20),
  	email varchar(256),
  	birthDate date, 
  	age int,
  	inDateTime datetime,
  	outDateTime datetime,
  	temperature float
  );
 */
public class Customer {
	Integer id;
	String name;
	String phone;
	String email;
	String birthday;
	Integer age;
	String inDateTime;
	String outDateTime;
	Float temperature;
		
	public Customer() {

	}

	public Customer(String name, String phone, String email, String birthday, Integer age, String inDateTime,
			String outDateTime, Float temperature) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.birthday = birthday;
		this.age = age;
		this.inDateTime = inDateTime;
		this.outDateTime = outDateTime;
		this.temperature = temperature;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getInDateTime() {
		return inDateTime;
	}

	public void setInDateTime(String inDateTime) {
		this.inDateTime = inDateTime;
	}

	public String getOutDateTime() {
		return outDateTime;
	}

	public void setOutDateTime(String outDateTime) {
		this.outDateTime = outDateTime;
	}

	public Float getTemperature() {
		return temperature;
	}

	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", phone=" + phone + ", email=" + email + ", birthday=" + birthday + ", age="
				+ age + ", inDateTime=" + inDateTime + ", outDateTime=" + outDateTime + ", temperature=" + temperature
				+ "]";
	}	
}
