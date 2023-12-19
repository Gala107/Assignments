package com.spring.hibernate.jdbc.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.hibernate.jdbc.bean.Employee;
import com.spring.hibernate.jdbc.dao.EmployeeDAO;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeDAO dao = (EmployeeDAO) context.getBean("edao");
		
//		Employee employee = new Employee();
//		employee.setId(4);
//		employee.setName("Kristin");
//		employee.setSalary(45000);
//		
//		int count = dao.addEmployee(employee);
//		System.out.println(count + " records added.");
		
		List<Employee> list = dao.getAllEmployees();
		for (Employee emp : list) {
			System.out.println(emp);
		}
		
		Employee employee = new Employee();
		employee.setId(4);
		employee.setName("Kristin");
		employee.setSalary(45000);
		dao.performMultiActions(employee);
	}
}
