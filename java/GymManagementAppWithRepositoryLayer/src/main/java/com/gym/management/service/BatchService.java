package com.gym.management.service;

import java.util.List;

import com.gym.management.model.Batch;
import com.gym.management.repository.BatchParticipantsRepository;
import com.gym.management.repository.model.ParticipantsBatch;

public class BatchService {

	BatchParticipantsRepository repository = new BatchParticipantsRepository();
	
	public ParticipantsBatch getBatchWithParticipants(String batchId) {
		return repository.getBatchWithParticipants(batchId);
	}
	
	public Batch getBatch(String id) {
		return repository.getBatch(id);
	}

	public void createBatch(Batch batch) {
		repository.createBatch(batch);
	}

	public void updateBatch(Batch batch) {
		repository.updateBatch(batch);
	}

	public List<Batch> getBatches() {
		return repository.getBatches();
	}
	
	public int deleteBatch(String id) {
		return repository.deleteBatch(id);				
	}
}
