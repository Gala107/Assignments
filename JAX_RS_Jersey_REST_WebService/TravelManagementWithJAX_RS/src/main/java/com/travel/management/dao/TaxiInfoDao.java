package com.travel.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.travel.management.bean.TaxiInfo;
import com.travel.management.resource.DBConnection;

public class TaxiInfoDao {

	public List<TaxiInfo> getAllTaxiInfo() {
		List<TaxiInfo> infos = new ArrayList<>();
		try {
			Connection connection = DBConnection.getDbConnection();
			PreparedStatement statement = connection.prepareStatement("select * from taxi_info");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TaxiInfo info = new TaxiInfo();
				info.setId(rs.getInt("id"));
				info.setCarModel(rs.getString("car_model"));
				info.setLicensePlate(rs.getString("license_plate"));
				infos.add(info);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return infos;
	}

	public TaxiInfo getTaxiInfo(int id) {
		try {
			Connection connection = DBConnection.getDbConnection();
			PreparedStatement statement = connection.prepareStatement("select * from taxi_info where id =?");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				TaxiInfo info = new TaxiInfo();
				info.setId(rs.getInt("id"));
				info.setCarModel(rs.getString("car_model"));
				info.setLicensePlate(rs.getString("license_plate"));
				return info;
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}
}
