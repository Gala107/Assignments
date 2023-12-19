package com.spring.hibernate.jdbc.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.hibernate.jdbc.bean.Employee;
import com.spring.hibernate.jdbc.dao.EmployeeDAO;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		EmployeeDAO empDao = (EmployeeDAO) context.getBean("empDao");
		
		Employee employee = new Employee("Palka", 100000);		
		empDao.createEmployee(employee);
		
		System.out.println(empDao.getAllEmployees());
	}
}
