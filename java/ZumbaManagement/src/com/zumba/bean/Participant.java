package com.zumba.bean;

import com.zumba.NotificationHandler;

public class Participant implements NotificationHandler{
	
	private String name;
	private String email;
	private int batchNum;
	
	public Participant(String name, String email, int batchNum) {
		super();
		this.name = name;
		this.email = email;
		this.batchNum = batchNum;
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

	public int getBatchNum() {
		return batchNum;
	}

	public void setBatchNum(int batchNum) {
		this.batchNum = batchNum;
	}

	@Override
	public void sendEmail() {
		System.out.println("* * * * *");
		System.out.println("Dear " + makeMePretty(name) + " at " + email + ", your Session #" + batchNum + " is starting. Please join us!");
		System.out.println("* * * * *");
	}
	
	String makeMePretty(String name) {
	    String prettyName = name;
	    try {
	    	prettyName = name.substring(0, 1).toUpperCase() + name.substring(1);
	    } catch (Exception e) {
	    }
	    return prettyName;
	}
}	
