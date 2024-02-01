package com.service;

import com.model.User;

public interface UserService {

	public boolean registerUser(User user);
	public boolean loginUser(User user);
	public boolean deleteUser(String email);
	public boolean updateUser(User user);
	public User getUser(String email);
	public User[] getUsers();
}
