package com.gym.management.repository;

import java.util.List;

import com.gym.management.dao.BatchDao;
import com.gym.management.dao.ParticipantDao;
import com.gym.management.model.Batch;
import com.gym.management.model.Participant;
import com.gym.management.repository.model.ParticipantsBatch;

public class BatchParticipantsRepository {
	BatchDao batchDao = new BatchDao();
	ParticipantDao participantDao = new ParticipantDao();
	
	public ParticipantsBatch getBatchWithParticipants(String id) {
		Batch batch = batchDao.getBatch(id);
		List<Participant> participants = participantDao.getParticipantsByBatch(id);
		ParticipantsBatch parBatch = new ParticipantsBatch(batch, participants);
		return parBatch;		
	}
	
	public Batch getBatch(String id) {
		return batchDao.getBatch(id);
	}

	public void createBatch(Batch batch) {
		batchDao.createBatch(batch);
	}

	public void updateBatch(Batch batch) {
		batchDao.updateBatch(batch);
	}

	public List<Batch> getBatches() {
		return batchDao.getAllBatches();
	}
	
	public int deleteBatch(String id) {
		return batchDao.deleteBatch(id);				
	}
	
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
