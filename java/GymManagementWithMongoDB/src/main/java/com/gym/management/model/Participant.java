package com.gym.management.model;

import org.bson.Document;

public class Participant {
	private static int count = 10;
	
	private int id;
	private String name;
	private String phone;
	private String email;
	private int batchId;
	
	public Participant() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	
	public Document getDocument() {
		Document document = new Document();
		document.append("_id", id == 0 ? count++ : id).append("name", name).append("phone", phone).append("email", email).append("batch_id", batchId);
		return document;
	}
}
