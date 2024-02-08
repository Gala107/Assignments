package com.travel.management.resource;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection con;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "root", "kalinka");
		} catch (Exception e) {
			System.err.println("Db Connection Error: " + e.toString());
		}
	}

	public static Connection getDbConnection() {
		try {
			return con;
		} catch (Exception e) {
			System.err.println("DB Connection Getting Connection Error: " + e.toString());
		}
		return null;
	}
}
