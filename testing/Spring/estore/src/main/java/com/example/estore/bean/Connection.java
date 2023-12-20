package com.example.estore.bean;

// Bean - POJO
public class Connection {

	String url;
	String username;
	String password;
	
	public Connection() {
		System.out.println("[Connection] Object is created.");
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
	@Override
	public String toString() {
		return "Connection [url=" + url + ", password=" + password + ", username=" + username + "]";
	}
}
