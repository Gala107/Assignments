package com.gym.management.resource;

import org.bson.Document;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DbConnection {

	static MongoCollection<Document> participantCollection;
	static MongoCollection<Document> batchCollection;
	public static final String PARTICIPANT_COLLECTION = "participant";
	public static final String BATCH_COLLECTION = "batch";

	/*
	 * Static block is executed once during class loading.
	 */
	static {
		String uri = "mongodb://localhost:27017";
		ServerApi serverApi = ServerApi.builder().version(ServerApiVersion.V1).build();
		MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(new ConnectionString(uri))
				.serverApi(serverApi).build();
		
		MongoClient mongoClient = MongoClients.create(settings);
		MongoDatabase database = mongoClient.getDatabase("mydb");

		participantCollection = database.getCollection("participant");
		batchCollection = database.getCollection("batch");
	}

	public static MongoCollection<Document> getCollection(String collectionType) {
		if (collectionType.equals(PARTICIPANT_COLLECTION)) {
			return participantCollection;
		} else if (collectionType.equals(BATCH_COLLECTION)) {
			return batchCollection;
		}
		return null;
	}
}
