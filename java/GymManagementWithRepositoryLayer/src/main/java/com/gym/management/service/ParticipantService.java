package com.gym.management.service;

import java.util.List;

import com.gym.management.dao.ParticipantDao;
import com.gym.management.model.Participant;

public class ParticipantService {

	ParticipantDao participantDao = new ParticipantDao();

	public void createParticipant(Participant participant) {
		participantDao.createParticipant(participant);

	}
	
	public Participant getParticipant(int id) {
		return participantDao.getParticipant(id);
	}

	public void updateParticipant(Participant participant) {
		participantDao.updateParticipant(participant);
	}

	public List<Participant> getParticipants() {
		return participantDao.getAllParticipants();
	}
	
	public List<Participant> getParticipantsByBatch(String batchId) {
		return participantDao.getParticipantsByBatch(batchId) ; 
	}

	public void deleteParticipant(int id) {
		participantDao.deleteParticipant(id);
	}
	
	public void updateParticipantsBatch(int[] participantIds, String batchId) {
		participantDao.updateParticipantsBatch(participantIds, batchId);
	}
}
