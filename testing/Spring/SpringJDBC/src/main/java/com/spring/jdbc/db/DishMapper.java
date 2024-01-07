package com.spring.jdbc.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.model.Dish;

public class DishMapper implements RowMapper<Dish>{

	@Override
	public Dish mapRow(ResultSet rs, int rowNum) throws SQLException {
		Dish dish = new Dish();
		dish.setId(rs.getInt(1));
		dish.setName(rs.getString(2));
		dish.setPrice(rs.getInt(3));
		
		return dish;
	}
}
