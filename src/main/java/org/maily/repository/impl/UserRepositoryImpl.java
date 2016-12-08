package org.maily.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.maily.model.User;
import org.maily.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl implements UserRepository {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void saveUser(User user) {
		entityManager.persist(user);

	}

	public List<User> findUsers() {
		String query = "Select u from User u";
		return entityManager.createQuery(query, User.class).getResultList();
	}

}
