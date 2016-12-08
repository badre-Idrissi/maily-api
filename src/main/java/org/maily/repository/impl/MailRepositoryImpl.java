package org.maily.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.maily.model.Mail;
import org.maily.repository.MailRepository;
import org.springframework.stereotype.Component;

@Component
public class MailRepositoryImpl implements MailRepository {

	
	@PersistenceContext
	EntityManager entityManager;
	
	public void saveMail(Mail mail) {
		entityManager.persist(mail);
	}

	public List<Mail> loadInBox(Integer id) {
		String query = "Select m from Mail m INNER JOIN m.receivers u where u.id = :id";
		return entityManager.createQuery(query, Mail.class)
							.setParameter("id", id)	
							.getResultList();
	}

	public List<Mail> loadSent(Integer id) {
		String query = "Select m from Mail m where m.sender.id = :id";
		return entityManager.createQuery(query, Mail.class)
							.setParameter("id", id)	
							.getResultList();
	}

}
