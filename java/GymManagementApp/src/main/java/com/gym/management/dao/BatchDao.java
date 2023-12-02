package com.gym.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.gym.management.model.Batch;
import com.gym.management.resource.DbConnection;

public class BatchDao {
	public int createBatch(Batch batch) {
		try {
			Connection connection = DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into batch values(?,?,?)");
			statement.setString(1, batch.getId());
			statement.setString(2, batch.getWeekDay());
			statement.setString(3, batch.getStartTime());
			return statement.executeUpdate();
		} catch (Exception e) {
			System.err.println("Not able to create a batch: " + e.toString());
		}
		return 0;
	}

	public Batch getBatch(String id) {
		try {
			Connection connection = DbConnection.getConnection();
			String query = "select * from batch where id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				Batch batch = new Batch();
				batch.setId(result.getString("id"));
				batch.setWeekDay(result.getString("week_day"));
				batch.setStartTime(result.getString("start_time"));
				return batch;
			}
		} catch (Exception e) {
			System.err.println("Not able to retrieve batch by id= " + id + " : " + e.toString());
		}
		return null;
	}

	public int updateBatch(Batch batch) {
		try {
			Connection connection = DbConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("update batch set week_day= ?, start_time = ? where id = ?");
			statement.setString(1, batch.getWeekDay());
			statement.setString(2, batch.getStartTime());
			statement.setString(3, batch.getId());
			return statement.executeUpdate();
		} catch (Exception e) {
			System.err.println("Not able to update batch with id= " + batch.getId() + " : " + e.toString());
		}
		return 0;

	}

	public int deleteBatch(String id) {
		try {
			Connection conection = DbConnection.getConnection();
			PreparedStatement statement = conection.prepareStatement("delete from batch where id = ?");
			statement.setString(1, id);
			return statement.executeUpdate();
		} catch(java.sql.SQLIntegrityConstraintViolationException e1) {
			System.err.println("Batch with id= " + id + " can't be deleted, it has participants assigned to it: " + e1.toString());
			return 5;
		} catch (Exception e2) {
			System.err.println("Not able to delete batch with id= " + id + " : " + e2.toString());
		}
		return 0;
	}

	public List<Batch> getAllBatches() {
		try {
			Connection connection = DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from batch order by id");
			ResultSet result = statement.executeQuery();
			List<Batch> batches = new ArrayList<Batch>();
			while (result.next()) {
				Batch batch = new Batch();
				batch.setId(result.getString("id"));
				batch.setWeekDay(result.getString("week_day"));
				batch.setStartTime(result.getString("start_time"));
				batches.add(batch);
			}
			return batches;
		} catch (Exception e) {
			System.err.println("Not able to retrieve all batches: " + e.toString());
		}
		return Collections.emptyList();
	}
}
