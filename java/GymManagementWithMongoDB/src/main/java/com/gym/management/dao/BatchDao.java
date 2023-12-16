package com.gym.management.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.gym.management.model.Batch;
import com.gym.management.resource.DbConnection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;

public class BatchDao {
	public int createBatch(Batch batch) {
		try {
			MongoCollection<Document> collection = DbConnection.getCollection(DbConnection.BATCH_COLLECTION);
			collection.insertOne(batch.getDocument());
			return 1;
		} catch (Exception e) {
			System.err.println("Not able to create a Batch: " + e.toString());
		}
		return 0;
	}

	public Batch getBatch(int id) {
		try {
			MongoCollection<Document> collection = DbConnection.getCollection(DbConnection.BATCH_COLLECTION);
			Document document = collection.find(Filters.eq("_id", id)).first();
			return (convertToBatch(document));
		} catch (Exception e) {
			System.err.println("Not able to retrieve all Batches: " + e.toString());
		}
		return null;
	}

	public int updateBatch(Batch batch) {
		try {
			MongoCollection<Document> collection = DbConnection.getCollection(DbConnection.BATCH_COLLECTION);
			Bson filter = Filters.eq("_id", batch.getId());
			Bson updates = Updates.combine(
					Updates.set("week_day", batch.getWeekDay()),
					Updates.set("start_time", batch.getStartTime()));
			collection.updateOne(filter, updates);
			return 1;
		} catch (Exception e) {
			System.err.println("Not able to update Batch with id= " + batch.getId() + " : " + e.toString());
		}
		return 0;

	}

	public int deleteBatch(int id) {
		try {
			MongoCollection<Document> collection = DbConnection.getCollection(DbConnection.BATCH_COLLECTION);
			DeleteResult result = collection.deleteOne(Filters.eq("_id", id));
			return (int) result.getDeletedCount();
		} catch (Exception e) {
			System.err.println("Not able to delete Batch with id= " + id + " : " + e.toString());
		}
		return 0;
	}

	public List<Batch> getAllBatches() {
		List<Batch> batches = new ArrayList<Batch>();
		try {
			MongoCollection<Document> collection = DbConnection.getCollection(DbConnection.BATCH_COLLECTION);
			List<Document> documents = collection.find().sort(Sorts.ascending("_id"))
					.into(new ArrayList<Document>());
			documents.forEach(document -> batches.add(convertToBatch(document)));
		} catch (Exception e) {
			System.err.println("Not able to retrieve all Batches: " + e.toString());
		}
		return batches;
	}

	private Batch convertToBatch(Document document) {
		Batch batch = new Batch();
		batch.setId(Integer.parseInt(document.get("_id").toString()));
		batch.setWeekDay(document.getString("week_day"));
		batch.setStartTime(document.getString("start_time"));
		return batch;
	}
}
