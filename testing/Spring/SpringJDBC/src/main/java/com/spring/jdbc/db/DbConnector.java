package com.spring.jdbc.db;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.model.Dish;

public class DbConnector {
	
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	
	public DbConnector() {
	
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("[DbConnector] Setter Injection on DataSource and JdbcTemplate Initialized.");
	}
	
	public void insertDish(Dish dish) {
		String sql = "insert into dish values(null, ?, ?)";
		// update -> used to insert, update and delete
		int result = jdbcTemplate.update(sql, dish.getName(), dish.getPrice());
		System.out.println("Dish " + dish.getName() + " inserted in Table");
	}
	
	public void fetchAllDishes() {
		String sql = "select * from dish";
		List<Dish> list = jdbcTemplate.query(sql, new DishMapper());	
		list.forEach(dish -> System.out.println(dish));
	}
}
