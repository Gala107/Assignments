package com.spring.hibernate.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.hibernate.jdbc.bean.Employee;

public class EmployeeMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee();
		emp.setId(rs.getInt("id"));
		emp.setName(rs.getString("name"));
		emp.setSalary(rs.getFloat("salary"));
		return emp;
	}
}
