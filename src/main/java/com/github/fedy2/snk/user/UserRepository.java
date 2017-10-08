/**
 * 
 */
package com.github.fedy2.snk.user;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
@Singleton
public class UserRepository {
	
	private Map<String, User> users;
	
	@Inject
	public UserRepository() {
		users = new HashMap<>();
	}
	
	public void add(User user) {
		users.put(user.getName(), user);
	}
	
	public User getOrCreate(String name) {
		
		if (exists(name)) {
			return get(name);
		} else {
			User user = new User(name);
			add(user);
			return user;
		}
	}
	
	public boolean exists(String name) {
		return users.containsKey(name);
	}
	
	public User get(String name) {
		return users.get(name);
	}

}
