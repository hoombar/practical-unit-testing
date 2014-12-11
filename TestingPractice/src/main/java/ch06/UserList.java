package main.java.ch06;

import java.util.HashSet;
import java.util.Set;

import main.java.ch05.subscribers.User;

public class UserList {

	Set<User> users = new HashSet<User>();
	
	public void add(User user) {
		users.add(user);
	}

	public Set<User> getUsers() {
		return users;
	}

}
