package org.maily.service;

import java.util.List;

import org.maily.model.Mail;
import org.maily.model.User;

public interface UserService {
	
	void save(User user);

	void sendMail(Integer id, Mail mail);

	List<Mail> loadInBox(Integer id);

	List<Mail> loadSent(Integer id);

}
