package com.spring.boot.microservice.model;

import java.util.List;

public class Response {

	Integer code;
	String message;
	List<TestProduct> products;

	public Response() {

	}

	public Response(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public Response(Integer code, String message, List<TestProduct> products) {
		super();
		this.code = code;
		this.message = message;
		this.products = products;
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

	public List<TestProduct> getProducts() {
		return products;
	}

	public void setProducts(List<TestProduct> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Response [code=" + code + ", message=" + message + ", products=" + products + "]";
	}
}
