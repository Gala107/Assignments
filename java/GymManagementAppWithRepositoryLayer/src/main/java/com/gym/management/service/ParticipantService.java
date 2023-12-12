package com.gym.management.service;

import java.util.List;

import com.gym.management.model.Participant;
import com.gym.management.repository.BatchParticipantsRepository;

public class ParticipantService {

	BatchParticipantsRepository repository = new BatchParticipantsRepository();

	public void createParticipant(Participant participant) {
		repository.createParticipant(participant);

	}
	
	public Participant getParticipant(int id) {
		return repository.getParticipant(id);
	}

	public void updateParticipant(Participant participant) {
		repository.updateParticipant(participant);
	}

	public List<Participant> getParticipants() {
		return repository.getParticipants();
	}
	
	public List<Participant> getParticipantsByBatch(String batchId) {
		return repository.getParticipantsByBatch(batchId) ; 
	}

	public void deleteParticipant(int id) {
		repository.deleteParticipant(id);
	}
	
	public void updateParticipantsBatch(int[] participantIds, String batchId) {
		repository.updateParticipantsBatch(participantIds, batchId);
	}
}
