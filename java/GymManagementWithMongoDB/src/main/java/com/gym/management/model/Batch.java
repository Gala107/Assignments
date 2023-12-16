package com.gym.management.model;

import org.bson.Document;

public class Batch {
	
	private int id;
	private String weekDay;
	private String startTime;
	
	public Batch() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	public Document getDocument() {
		Document document = new Document();
		document.append("_id", id).append("week_day", weekDay).append("start_time", startTime);
		return document;
	}
}
