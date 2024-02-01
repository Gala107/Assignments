package com.service;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import com.model.User;

public class UserServiceImpl implements UserService {

	static LinkedHashMap<String, User> users = new LinkedHashMap<String, User>();

	@Override
	public boolean registerUser(User user) {
		if (user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
			return false;
		} else {
			users.put(user.getEmail(), user);
		}

		return true;
	}

	@Override
	public boolean loginUser(User user) {
		User userToCheck = users.get(user.getEmail());
		return userToCheck.getPassword().equals(user.getPassword());
	}

	@Override
	public boolean deleteUser(String email) {
		if (!users.containsKey(email)) {
			return false;
		}
		users.remove(email);
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		if (!users.containsKey(user.getEmail())) {
			return false;
		}
		users.put(user.getEmail(), user);
		return true;
	}

	@Override
	public User getUser(String email) {
		if (!users.containsKey(email)) {
			return null;
		}
		return users.get(email);
	}

	@Override
	public User[] getUsers() {
		User[] userArray = new User[users.size()];
		Set<String> emails = users.keySet();

		int idx = 0;
		Iterator<String> itr = emails.iterator();
		while (itr.hasNext()) {
			String email = itr.next();
			userArray[idx++] = users.get(email);
		}

		return userArray;
	}
}
