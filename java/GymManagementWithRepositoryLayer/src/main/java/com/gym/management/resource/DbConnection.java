package com.gym.management.resource;

import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.cj.jdbc.Driver;

public class DbConnection {

	static Connection connection;

	/*
	 * Static block is executed once during class loading.
	 */
	static {
		try {
			DriverManager.registerDriver(new Driver());
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_management", "root", "kalinka");
		} catch (Exception e) {
			System.out.println("Not able to create DB connection: " + e.toString());
		}
	}

	public static Connection getConnection() {
		return connection;
	}
}
