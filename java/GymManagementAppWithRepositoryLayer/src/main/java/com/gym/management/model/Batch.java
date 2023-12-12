package com.gym.management.model;

public class Batch {
	
	private String id;
	private String weekDay;
	private String startTime;
	
	public Batch() {

	}

	public Batch(String id, String weekDay, String startTime) {
		super();
		this.id = id;
		this.weekDay = weekDay;
		this.startTime = startTime;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}	
}
