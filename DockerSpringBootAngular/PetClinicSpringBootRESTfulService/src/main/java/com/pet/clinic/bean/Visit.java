package com.pet.clinic.bean;

import org.springframework.context.annotation.Scope;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Scope("prototype")
public class Visit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String date;
	private String time;
	private String reason;
	private Integer petId;
	
	public Visit() {

	}
	public Visit(Integer id, String date, String time, String reason, Integer petId) {
		this.id = id;
		this.date = date;
		this.time = time;
		this.reason = reason;
		this.petId = petId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Integer getPetId() {
		return petId;
	}
	public void setPetId(Integer petId) {
		this.petId = petId;
	}
}
