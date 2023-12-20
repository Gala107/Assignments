package com.spring.application.context.bean;

// Bean - POJO
public class Connection {

	String url;
	String username;
	String password;
	
	public Connection() {
		System.out.println("[Connection] Object is created. HashCode: " + hashCode());
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	// User defined methods/ can have any name for bean life cycle.
	// Signature requirement: void return type and no arguments.
	public void myInit() {
		System.out.println("[Connection] myInit is executed for username:  " + username);
	}
	// User defined methods/ can have any name for bean life cycle.
	// Signature requirement: void return type and no arguments.
	public void myDestroy() {
		System.out.println("[Connection] myDestroy is executed for username: " + username);
	}
	@Override
	public String toString() {
		return "Connection [url=" + url + ", password=" + password + ", username=" + username + "]";
	}
}
