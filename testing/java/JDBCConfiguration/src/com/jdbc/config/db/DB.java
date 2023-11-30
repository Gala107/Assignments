package com.jdbc.config.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
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
	PreparedStatement preparedStatement;

	// Used for Stored Procedures.
	CallableStatement callableStatement;
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

//			String sql = "insert into Customer values(null, '" + customer.getName() + "','" + customer.getPhone()
//					+ "','" + customer.getEmail() + "','" + date1 + "','" + customer.getAge() + "','" + date2 + "','"
//					+ date2 + "'," + customer.getTemperature() + ")";

			String sql = "insert into Customer values(null,?,?,?,?,?,?,?,?)";
			System.out.println(sql);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getPhone());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.setString(4, customer.getBirthday());
			preparedStatement.setInt(5, customer.getAge());
			preparedStatement.setString(6, customer.getInDateTime());
			preparedStatement.setString(7, customer.getOutDateTime());
			preparedStatement.setFloat(8, customer.getTemperature());

			// int result = statement.executeUpdate(sql);
			int result = preparedStatement.executeUpdate();
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

	/**
	 * Stored Procedure is created and stored in database info: No return value in
	 * Stored Procedure. delimiter // create procedure addUser(in name varchar(255),
	 * in created_by varchar(255)) begin insert into user values(null, null,
	 * created_by, name); end //
	 * 
	 * How to call procedure in db: call addUser('gala', '123'); //
	 */
	public void executeProcedure(String name, String created_by) {
		try {
			String query = "call addUser(?, ?)";
			callableStatement = connection.prepareCall(query);
			callableStatement.setString(1, name);
			callableStatement.setString(2, created_by);
			callableStatement.execute();

			System.out.println("Stored Procedure is executed.");
		} catch (Exception e) {

		}
	}

	/**
	 * Calling Stored Procedure with returned value.
	 * 
	 * @param name
	 */
	public void executeProcedure(int cid) {
		try {
			String query = "call getName(?, @_name)";
			callableStatement = connection.prepareCall(query);
			callableStatement.setInt(1, cid);

			ResultSet result = callableStatement.executeQuery();
			if (result.next()) {
				System.out.println("Found the customer with ID: " + cid);

				// only 1 column is returned that's why: result.getString(1);
				System.out.println("Customer name: " + result.getString(1));
			} else {
				System.out.println("Sorry? No customer found with ID: " + cid);
			}
			System.out.println("Stored Procedure is executed.");
		} catch (Exception e) {

		}
	}

	public void executeMyBatch() {
		try {
			String query = "insert into employee values(16, 'John', 5000)";
			String query2 = "insert into employee values(17, 'Leonard', 1000)";
			String query3 = "insert into employee values(18, 'Arisha', 3000)";
			String query4 = "insert into employee values(19, 'Ezra', 12000)";

			statement.addBatch(query);
			statement.addBatch(query2);
			statement.addBatch(query3);
			statement.addBatch(query4);

			int[] results = statement.executeBatch();

			System.out.println("Batch executed.");
		} catch (Exception e) {

		}
	}

	public void executeBatchWithPreparedStatement() {
		try {
			String query = "insert into employee values(?,?,?)";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 23);
			preparedStatement.setString(2, "Alica");
			preparedStatement.setFloat(3, 1000);
			preparedStatement.addBatch();

			preparedStatement.setInt(1, 33);
			preparedStatement.setString(2, "Ben");
			preparedStatement.setFloat(3, 800);
			preparedStatement.addBatch();

			int[] results = preparedStatement.executeBatch();

			System.out.println("Batch executed.");
		} catch (Exception e) {

		}
	}

	public void executeTransaction() {
		try {
			connection.setAutoCommit(false);

			String query = "insert into orders values(null, 15, '2022-01-09', 4300)";
			String query2 = "insert into orders values(null, 4, '2022-01-11', 9900)";

			query = "insert into orders values(null, 7, '2000-01-01', 5555)";
			query2 = "update orders set order_amount = 7600 where order_id = 4";
			String query3 = "delete from orders where order_id = 1";

			statement.addBatch(query);
			statement.addBatch(query2);
			statement.addBatch(query3);

			statement.executeBatch();
			connection.commit();
			System.out.println("Batch is executed and Transaction is committed.");
		} catch (Exception e) {
			System.err.println("Not able to execute transaction: " + e);
			try {
				System.err.println("Rolling back the transaction.");
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				connection.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void showMetadata() {
		try {
			DatabaseMetaData dbMetaData = connection.getMetaData();
			System.out.println("Product name: " + dbMetaData.getDatabaseProductName());
			System.out.println("Version: " + dbMetaData.getDatabaseProductVersion());
			System.out.println("Major Version: " + dbMetaData.getDatabaseMajorVersion());
			System.out.println("Minor Version: " + dbMetaData.getDatabaseMinorVersion());
			System.out.println("Driver Version: " + dbMetaData.getDriverVersion());
			System.out.println("Driver Name: " + dbMetaData.getDriverName());
			System.out.println("User name: " +dbMetaData.getUserName());
			
			System.out.println();
			System.out.println("Listing Tables");
			System.out.println();
			String projection[] = {"TABLE"};
			ResultSet result = dbMetaData.getTables(null, null, null, projection);
			while(result.next()) {
				System.out.println(result.getString("TABLE_NAME"));
			}
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e);
		}
	}
}
