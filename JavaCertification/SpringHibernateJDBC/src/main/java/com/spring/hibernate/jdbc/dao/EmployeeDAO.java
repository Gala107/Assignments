package com.spring.hibernate.jdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import com.spring.hibernate.jdbc.bean.Employee;

public class EmployeeDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private PlatformTransactionManager transactionManager;

	public int addEmployee(Employee e) {
		int count = 0;
		String query = "insert into employee values(?,?,?)";
		count = jdbcTemplate.update(query, e.getId(), e.getName(), e.getSalary());
		return count;
	}

	public List<Employee> getAllEmployees() {
		String query = "select * from employee";
		@SuppressWarnings("unchecked")
		List<Employee> list = jdbcTemplate.query(query, new EmployeeMapper());
		return list;
	}

	public List<Employee> getEmployeesBySalary(float salary) {
		String query = "select * from employee where salary=?";
		@SuppressWarnings("unchecked")
		List<Employee> list = jdbcTemplate.query(query, new EmployeeMapper(), salary);
		return list;
	}

	public void performMultiActions(Employee empl) {
		System.out.println();
		System.out.println("Performing Multiple Actions");
		TransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(definition);
		try {
			String query = "insert into employee values(?,?,?)";
			int count = jdbcTemplate.update(query, empl.getId(), empl.getName(), empl.getSalary());
			System.out.println(count + " records inserted.");

			query = "select * from employee where salary=(select max(salary) from employee)";
			@SuppressWarnings("unchecked")
			List<Employee> list = jdbcTemplate.query(query, new EmployeeMapper());
			System.out.println("max salary: " + list);
			transactionManager.commit(status);
		} catch (Exception e) {
			System.err.println("Transaction Failed: " + e);
			transactionManager.rollback(status);
		}
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(this.dataSource);
	}

	public DataSource getDataSource() {
		return dataSource;
	}
}
