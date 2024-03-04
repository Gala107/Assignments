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
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String type;
	private String breed;
	private String dob;
	private Integer ownerId;
	
	@OneToMany(mappedBy = "petId", cascade = CascadeType.ALL)
	private List<Visit> visits;
	
	public Pet() {

	}
	public Pet(Integer id, String name, String type, String breed, String dob) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.breed = breed;
		this.dob = dob;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public List<Visit> getVisits() {
		return visits;
	}
	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
}
