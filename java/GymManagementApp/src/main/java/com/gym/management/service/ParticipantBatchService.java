package com.gym.management.service;

import java.util.List;

import com.gym.management.dao.BatchDao;
import com.gym.management.dao.ParticipantDao;
import com.gym.management.model.Batch;
import com.gym.management.model.Participant;

public class ParticipantBatchService {

	ParticipantDao participantDao = new ParticipantDao();
	BatchDao batchDao = new BatchDao();

	public void createParticipant(Participant participant) {
		participantDao.createParticipant(participant);

	}

	public void updateParticipant(Participant participant) {
		participantDao.updateParticipant(participant);
	}

	public void createBatch(Batch batch) {
		batchDao.createBatch(batch);
	}

	public void updateBatch(Batch batch) {
		batchDao.updateBatch(batch);
	}

	public List<Participant> getParticipants() {
		return participantDao.getAllParticipants();
	}

	public List<Batch> getBatches() {
		return batchDao.getAllBatches();
	}
}
