package com.zumba.bean;

import java.util.List;

import com.zumba.NotificationHandler;

public class Batch extends Thread {
	
	private int batchNum;
	private List<NotificationHandler> participants;
	
	public Batch(int batchNum, List<NotificationHandler> participants) {
		this.batchNum = batchNum;
		this.participants = participants;
	}

	public int getBatchNum() {
		return batchNum;
	}

	public void setBatchNum(int batchNum) {
		this.batchNum = batchNum;
	}

	public List<NotificationHandler> getParticipants() {
		return participants;
	}

	public void setParticipants(List<NotificationHandler> participants) {
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		participants.forEach(NotificationHandler::sendEmail);
	}		
}
