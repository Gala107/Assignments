package com.gym.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import com.gym.management.model.Participant;
import com.gym.management.resource.DbConnection;

public class ParticipantDao {

	public int createParticipant(Participant participant) {
		try {
			Connection connection = DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into participant values(?,?,?,?,?)");
			statement.setInt(1, (int) UUID.randomUUID().getLeastSignificantBits());
			statement.setString(2, participant.getName());
			statement.setString(3, participant.getEmail());
			statement.setString(4, participant.getPhone());
			statement.setString(5, participant.getBatchId());
			return statement.executeUpdate();
		} catch (Exception e) {
			System.err.println("Not able to create participant: " + e.toString());
		}
		return 0;
	}

	public Participant getParticipant(int id) {
		try {
			Connection connection = DbConnection.getConnection();
			String query = "select * from participant where id = " + id;
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				Participant participant = new Participant();
				participant.setId(result.getInt("id"));
				participant.setName(result.getString("name"));
				participant.setEmail(result.getString("email"));
				participant.setPhone(result.getString("phone"));
				participant.setBatchId(result.getString("batch_id"));
				return participant;
			}
		} catch (Exception e) {
			System.err.println("Not able to retrieve participant by id= " + id + " : " + e.toString());
		}
		return null;
	}

	public int updateParticipant(Participant participant) {
		try {
			Connection connection = DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"update participant set name = ?, email = ?, phone = ?, batchId = ? where id = ?");
			statement.setString(1, participant.getName());
			statement.setString(2, participant.getEmail());
			statement.setString(3, participant.getPhone());
			statement.setString(4, participant.getBatchId());
			statement.setInt(5, participant.getId());
			return statement.executeUpdate();
		} catch (Exception e) {
			System.err.println("Not able to update participant with id= " + participant.getId() + " : " + e.toString());
		}
		return 0;
	}

	public int deleteProduct(int id) {
		try {
			Connection conection = DbConnection.getConnection();
			PreparedStatement statement = conection.prepareStatement("delete from particiipant where id = ?");
			statement.setInt(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			System.err.println("Not able to delete participant with id= " + id + " : " + e.toString());
		}
		return 0;
	}

	public List<Participant> getAllParticipants() {
		try {
			Connection connection = DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from participant");
			ResultSet result = statement.executeQuery();
			List<Participant> batches = new ArrayList<Participant>();
			while (result.next()) {
				Participant participant = new Participant();
				participant.setId(result.getInt("id"));
				participant.setName(result.getString("name"));
				participant.setEmail(result.getString("email"));
				participant.setPhone(result.getString("phone"));
				participant.setBatchId(result.getString("batch_id"));
				batches.add(participant);
			}
			return batches;
		} catch (Exception e) {
			System.err.println("Not able to retrieve all batches" + e.toString());
		}
		return Collections.emptyList();
	}
}
