package com.travel.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.travel.management.bean.TaxiReservation;
import com.travel.management.resource.DBConnection;

public class TaxiReservationDao {

	public int saveTaxiReservation(TaxiReservation reservation) {
		try {
			Connection connection = DBConnection.getDbConnection();
			PreparedStatement statement = connection
					.prepareStatement("insert into taxi_reservation values(?,?,?,?,?,?,?,?,?)");
			statement.setInt(1, 0);
			statement.setString(2, reservation.getClientName());
			statement.setString(3, reservation.getClientEmail());
			statement.setString(4, reservation.getClientPhone());
			statement.setString(5, reservation.getPickupLocation());;
			statement.setString(6, reservation.getPickupTime());
			statement.setString(7, reservation.getDestination());
			statement.setInt(8, reservation.getPassengerNum());
			statement.setString(9, reservation.getCarModel());
			return statement.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}

	public TaxiReservation getTaxiReservation(int id) {
		try {
			Connection connection = DBConnection.getDbConnection();
			PreparedStatement statement = connection.prepareStatement("select * from taxi_resesrvation where id = ?");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				TaxiReservation reservation = new TaxiReservation();
				reservation.setId(rs.getInt("id"));
				reservation.setClientName(rs.getString("client_name"));
				reservation.setClientEmail(rs.getString("client_email"));
				reservation.setClientPhone(rs.getString("client_phone"));
				reservation.setPickupLocation(rs.getString("pickup_location"));
				reservation.setPickupTime(rs.getString("pickup_time"));
				reservation.setDestination(rs.getString("destination"));
				reservation.setPassengerNum(rs.getInt("passenger_num"));
				reservation.setCarModel(rs.getString("car_model"));
				return reservation;
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	public List<TaxiReservation> getAllTaxiReservations() {
		List<TaxiReservation> reservations = new ArrayList<TaxiReservation>();
		try {
			Connection connection = DBConnection.getDbConnection();
			PreparedStatement statement = connection.prepareStatement("select * from taxi_reservation");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TaxiReservation reservation = new TaxiReservation();
				reservation.setId(rs.getInt("id"));
				reservation.setClientName(rs.getString("client_name"));
				reservation.setClientEmail(rs.getString("client_email"));
				reservation.setClientPhone(rs.getString("client_phone"));
				reservation.setPickupLocation(rs.getString("pickup_location"));
				reservation.setPickupTime(rs.getString("pickup_time"));
				reservation.setDestination(rs.getString("destination"));
				reservation.setPassengerNum(rs.getInt("passenger_num"));
				reservation.setCarModel(rs.getString("car_model"));
				reservations.add(reservation);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return reservations;
	}

	public int deleteTaxiReservation(int id) {
		try {
			Connection connection = DBConnection.getDbConnection();
			PreparedStatement statement = connection.prepareStatement("delete from taxi_reservation where id =?");
			statement.setInt(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
}
