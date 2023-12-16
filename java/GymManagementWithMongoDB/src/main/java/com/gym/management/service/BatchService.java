package com.gym.management.service;

import java.util.List;

import com.gym.management.dao.BatchDao;
import com.gym.management.model.Batch;

public class BatchService {

	BatchDao batchDao = new BatchDao();
	
	public Batch getBatch(int id) {
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
	
	public int deleteBatch(int id) {
		return batchDao.deleteBatch(id);				
	}
}
