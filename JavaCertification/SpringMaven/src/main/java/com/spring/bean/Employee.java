package com.spring.bean;

public class Employee {
	private int employeeId;
	private String employeeName;
	
	public Employee() {
		System.out.println("Default Employee Constructor is called.");
	}
	
	public Employee(int employeeId, String employeeName) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		System.out.println("Parametarized Employee Constructor is called.");
	}

	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		System.out.println("Setting Employee Id is called.");
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		System.out.println("Setting Employee Name is called.");
		this.employeeName = employeeName;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + "]";
	}
}
