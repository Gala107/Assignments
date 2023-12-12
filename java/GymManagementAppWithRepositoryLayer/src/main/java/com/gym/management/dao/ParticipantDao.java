package com.gym.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.gym.management.model.Participant;
import com.gym.management.resource.DbConnection;

public class ParticipantDao {

	public int createParticipant(Participant participant) {
		try {
			Connection connection = DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into participant values(null,?,?,?,?)");
			statement.setString(1, participant.getName());
			statement.setString(2, participant.getEmail());
			statement.setString(3, participant.getPhone());
			statement.setString(4, participant.getBatchId());
			return statement.executeUpdate();
		} catch (Exception e) {
			System.err.println("Not able to create Psarticipant: " + e.toString());
		}
		return 0;
	}

	public Participant getParticipant(int id) {
		try {
			Connection connection = DbConnection.getConnection();
			String query = "select * from participant where id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
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
			System.err.println("Not able to retrieve Participant by id= " + id + " : " + e.toString());
		}
		return null;
	}

	public int updateParticipant(Participant participant) {
		try {
			Connection connection = DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"update participant set name = ?, email = ?, phone = ?, batch_id = ? where id = ?");
			statement.setString(1, participant.getName());
			statement.setString(2, participant.getEmail());
			statement.setString(3, participant.getPhone());
			statement.setString(4, participant.getBatchId());
			statement.setInt(5, participant.getId());
			return statement.executeUpdate();
		} catch (Exception e) {
			System.err.println("Not able to update Participant with id= " + participant.getId() + " : " + e.toString());
		}
		return 0;
	}

	public int[] updateParticipantsBatch(int[] participantsIds, String batchId) {
		Connection connection = null;
		try {
			connection = DbConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("update participant set batch_id = ? where id = ?");

			for (Integer participantId : participantsIds) {
				statement.setString(1, batchId);
				statement.setInt(2, participantId);
				statement.addBatch();
			}

			return statement.executeBatch();

		} catch (Exception e) {
			System.err.println("Not able to update Participants with Batch Id " + batchId + ": " + e.toString());
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return null;
	}

	public int deleteParticipant(int id) {
		try {
			Connection conection = DbConnection.getConnection();
			PreparedStatement statement = conection.prepareStatement("delete from participant where id = ?");
			statement.setInt(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			System.err.println("Not able to delete Participant with id= " + id + " : " + e.toString());
		}
		return 0;
	}

	public List<Participant> getAllParticipants() {
		try {
			Connection connection = DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from participant order by name");
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
			System.err.println("Not able to retrieve all Participants" + e.toString());
		}
		return Collections.emptyList();
	}
	
	public List<Participant> getParticipantsByBatch(String batchId) {
		try {
			Connection connection = DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from participant where batch_id = ? order by name");
			statement.setString(1, batchId);
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
			System.err.println("Not able to retrieve participants for Batch " + batchId + ": " + e.toString());
		}
		return Collections.emptyList();
	}
}
