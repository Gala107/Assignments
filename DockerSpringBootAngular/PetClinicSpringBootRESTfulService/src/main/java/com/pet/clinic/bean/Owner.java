package com.pet.clinic.bean;

import java.util.List;

import org.springframework.context.annotation.Scope;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Scope("prototype")
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String address;
	private String phone;
	private String email;
	
	@OneToMany(mappedBy = "ownerId", cascade = CascadeType.ALL)
	private List<Pet> pets;
	
	public Owner() {
	
	}
	public Owner(Integer id, String name, String address, String phone, String email, List<Pet> pets) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.pets = pets;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public List<Pet> getPets() {
		return pets;
	}
	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
}
