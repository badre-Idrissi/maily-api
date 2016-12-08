package org.maily.service.impl;

import java.util.List;

import org.maily.model.Mail;
import org.maily.model.User;
import org.maily.repository.MailRepository;
import org.maily.repository.UserRepository;
import org.maily.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MailRepository mailRepository;
	
	public void save(User user) {
		userRepository.saveUser(user);
	}

	public void sendMail(Integer id, Mail mail) {
		User user = new User();
		user.setId(id);
		mail.setSender(user);
		mailRepository.saveMail(mail);
	}

	public List<Mail> loadInBox(Integer id) {
		return mailRepository.loadInBox(id);
	}

	public List<Mail> loadSent(Integer id) {
		return mailRepository.loadSent(id);
	}
}
