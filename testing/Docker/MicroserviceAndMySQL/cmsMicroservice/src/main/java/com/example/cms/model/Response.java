package com.example.cms.model;

import java.util.List;

public class Response {
	
	Integer code;
	String message;
	List<Customer> customers;
	
	public Response() {

	}
	public Response(Integer code, String message, List<Customer> customers) {
		this.code = code;
		this.message = message;
		this.customers = customers;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	@Override
	public String toString() {
		return "Response [code=" + code + ", message=" + message + "]";
	}
}
