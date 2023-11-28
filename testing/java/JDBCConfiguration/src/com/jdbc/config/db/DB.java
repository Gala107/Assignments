package com.jdbc.config.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.jdbc.config.model.Customer;
import com.mysql.cj.jdbc.Driver;

/**
 * 1. Download the Driver and link it to the Project. For Maven simply configure
 * the dependency in the pom.xml file. 2. Load the Driver from the library. 3.
 * Create Connection to the database with url, user and password. 4. Execute
 * CRUD operations. 5. Close the Connection.
 */
public class DB implements DAO {

	Connection connection;
	Statement statement;
	final String TAG = getClass().getSimpleName();

	public DB() {
		try {
			DriverManager.registerDriver(new Driver());
			System.out.println("[" + TAG + "]" + " Driver loaded.");
		} catch (Exception e) {
			System.err.println("Exception Occurred: " + e);
		}
	}

	@Override
	public void createConnection() {
		try {
			String user = "root";
			String password = "kalinka";
			String url = "jdbc:mysql://localhost/info";
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();
			System.out.println("[" + TAG + "]" + " Connection created.");
		} catch (Exception e) {
			System.err.println("Exception Occurred: " + e);
		}
	}

	@Override
	public void closeConnection() {
		try {
			connection.close();
			System.out.println("[" + TAG + "]" + " Connection closed. Close status: " + connection.isClosed());
		} catch (Exception e) {
			System.err.println("Exception Occurred: " + e);
		}
	}

	@Override
	public void createCustomer(Customer customer) {
		try {
			// Date -> YYYY-MM-DD
			// DateTime -> YYYY-MM-DD hh:mm:ss
			SimpleDateFormat pattern1 = new SimpleDateFormat("YYYY-MM-dd");
			SimpleDateFormat pattern2 = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");

			Date date = new Date();
			String date1 = pattern1.format(date);
			String date2 = pattern2.format(date);
//			System.out.println("Date 1 : " + date1);
//			System.out.println("Date 2 : " + date2);

			String sql = "insert into Customer values(null, '" + customer.getName() + "','" + customer.getPhone()
					+ "','" + customer.getEmail() + "','" + date1 + "','" + customer.getAge() + "','" + date2 + "','"
					+ date2 + "'," + customer.getTemperature() + ")";
			System.out.println(sql);

			int result = statement.executeUpdate(sql);
			String message = result > 0 ? "Customer created successfully" : "Customer not created. Please try again.";
			System.out.println("[" + TAG + "]" + message);
		} catch (Exception e) {
			System.err.println("Exception Occurred: " + e);
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
		try {
			String sql = "update Customer set name = '" + customer.getName() + "',phone = '" + customer.getPhone()
					+ "', email = '" + customer.getEmail() + "', birthDate = '" + customer.getBirthday() + "', age = "
					+ customer.getAge() + ", inDateTime = '" + customer.getInDateTime() + "', outDateTime = '"
					+ customer.getOutDateTime() + "', temperature = " + customer.getTemperature() + " where cid = "
					+ customer.getId();
			System.out.println(sql);

			int result = statement.executeUpdate(sql);
			String message = result > 0 ? "Customer updated successfully" : "Customer not updated. Please try again.";
			System.out.println("[" + TAG + "]" + message);
		} catch (Exception e) {
			System.err.println("Exception Occurred: " + e);
		}

	}

	@Override
	public void deleteCustomer(int id) {
		try {
			String query = "delete from customer where cid = " + id;
			int result = statement.executeUpdate(query);
			
			String message = result > 0 ? "Customer deleted successfully" : "Customer not deleted. Please try again.";
			System.out.println("[" + TAG + "]" + message);
		} catch (Exception e) {
			System.err.println("Exception Occurred: " + e);
		}
	}

	@Override
	public ArrayList<Customer> getCustomers() {
		ArrayList<Customer> customers = new ArrayList<Customer>();

		try {
			String query = "select * from customer";

			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				Customer customer = new Customer();
				customer.setId(result.getInt("cid"));
				customer.setAge(result.getInt("age"));
				customer.setBirthday(result.getString("birthDate"));
				customer.setEmail(result.getString("email"));
				customer.setInDateTime(result.getString("inDateTime"));
				customer.setOutDateTime(result.getString("outDateTime"));
				customer.setTemperature(result.getFloat("temperature"));
				customer.setName(result.getString("name"));
				customer.setPhone(result.getString("phone"));

				customers.add(customer);
			}

		} catch (Exception e) {
			System.err.println("Exception Occurred: " + e);
		}

		return customers;
	}
}
