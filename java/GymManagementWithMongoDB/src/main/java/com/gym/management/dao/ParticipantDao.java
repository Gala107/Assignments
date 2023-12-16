package com.gym.management.dao;


import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.gym.management.model.Participant;
import com.gym.management.resource.DbConnection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;

public class ParticipantDao {

	public int createParticipant(Participant participant) {
		try {
			MongoCollection<Document> collection = DbConnection.getCollection(DbConnection.PARTICIPANT_COLLECTION);
			collection.insertOne(participant.getDocument());
			return 1;
		} catch (Exception e) {
			System.err.println("Not able to create Psarticipant: " + e.toString());
		}
		return 0;
	}

	public Participant getParticipant(int id) {
		try {
			MongoCollection<Document> collection = DbConnection.getCollection(DbConnection.PARTICIPANT_COLLECTION);
			// Document filter = new Document("batch_id", batchId);
			// Document document = collection.find(filter).first();
			Document document = collection.find(Filters.eq("_id", id)).first();
			return (convertToParticipant(document));
		} catch (Exception e) {
			System.err.println("Not able to retrieve participant with id " + id + ": " + e.toString());
		}
		return null;
	}

	public int updateParticipant(Participant participant) {
		try {
			MongoCollection<Document> collection = DbConnection.getCollection(DbConnection.PARTICIPANT_COLLECTION);
			Bson filter = Filters.eq("_id", participant.getId());
			Bson updates = Updates.combine(Updates.set("name", participant.getName()),
					Updates.set("phone", participant.getPhone()), Updates.set("email", participant.getEmail()),
					Updates.set("batch_id", participant.getBatchId()));
			collection.updateOne(filter, updates);
			return 1;
		} catch (Exception e) {
			System.err.println("Not able to update Participant with id= " + participant.getId() + " : " + e.toString());
		}
		return 0;
	}

	public int updateParticipantsBatch(int[] participantsIds, String batchId) {
		try {
			MongoCollection<Document> collection = DbConnection.getCollection(DbConnection.PARTICIPANT_COLLECTION);
			Bson filter = Filters.all("_id", participantsIds);
			Bson update = Updates.set("batch_id", batchId);
			collection.updateMany(filter, update);
			return 1;
		} catch (Exception e) {
			System.err.println("Not able to update Participants with Batch Id " + batchId + ": " + e.toString());
		}
		return 0;
	}

	public int deleteParticipant(int id) {
		try {
			MongoCollection<Document> collection = DbConnection.getCollection(DbConnection.PARTICIPANT_COLLECTION);
			DeleteResult result = collection.deleteOne(Filters.eq("_id", id));
			return (int) result.getDeletedCount();
		} catch (Exception e) {
			System.err.println("Not able to delete Participant with id= " + id + " : " + e.toString());
		}
		return 0;
	}

	public List<Participant> getAllParticipants() {
		List<Participant> participants = new ArrayList<Participant>();
		try {
			MongoCollection<Document> collection = DbConnection.getCollection(DbConnection.PARTICIPANT_COLLECTION);
			List<Document> documents = collection.find().sort(Sorts.ascending("name")).into(new ArrayList<Document>());
			documents.forEach(document -> participants.add(convertToParticipant(document)));
		} catch (Exception e) {
			System.err.println("Not able to retrieve all participants: " + e.toString());
		}
		return participants;
	}

	public List<Participant> getParticipantsByBatch(int batchId) {
		List<Participant> participants = new ArrayList<Participant>();
		try {
			MongoCollection<Document> collection = DbConnection.getCollection(DbConnection.PARTICIPANT_COLLECTION);
			// Document filter = new Document("batch_id", batchId);
			// List<Document> documents = collection.find(filter).into(new ArrayList<Document>());
			List<Document> documents = collection.find(Filters.eq("batch_id", batchId)).sort(Sorts.ascending("name"))
					.into(new ArrayList<Document>());
			documents.forEach(document -> participants.add(convertToParticipant(document)));
		} catch (Exception e) {
			System.err.println("Not able to retrieve participants for Batch " + batchId + ": " + e.toString());
		}
		return participants;
	}

	private Participant convertToParticipant(Document document) {
		Participant participant = new Participant();
		participant.setId(Integer.parseInt(document.get("_id").toString()));
		participant.setName(document.get("name").toString());
		participant.setEmail(document.get("email").toString());
		participant.setPhone(document.get("phone").toString());
		participant.setBatchId(Integer.parseInt(document.get("batch_id").toString()));
		return participant;
	}
}
