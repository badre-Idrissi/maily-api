package org.maily.repository;

import java.util.List;

import org.maily.model.User;

public interface UserRepository {
	
	void saveUser(User user);
	
	List<User> findUsers();

}
