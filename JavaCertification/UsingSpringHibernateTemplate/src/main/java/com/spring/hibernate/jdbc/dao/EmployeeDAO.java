package com.spring.hibernate.jdbc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.hibernate.jdbc.bean.Employee;

public class EmployeeDAO {
	
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void createEmployee(Employee employee) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.persist(employee);
		session.getTransaction().commit();
	}
	
	public List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		list = hibernateTemplate.loadAll(Employee.class);
		return list;
	}
}
