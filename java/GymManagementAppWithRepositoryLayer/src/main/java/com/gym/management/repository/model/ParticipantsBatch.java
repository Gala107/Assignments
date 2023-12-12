package com.gym.management.repository.model;

import java.util.List;

import com.gym.management.model.Batch;
import com.gym.management.model.Participant;

public class ParticipantsBatch extends Batch {
	private List<Participant> participants;

	public ParticipantsBatch(Batch batch, List<Participant> participants) {
		super(batch.getId(), batch.getWeekDay(), batch.getStartTime());
		this.participants = participants;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}
}
