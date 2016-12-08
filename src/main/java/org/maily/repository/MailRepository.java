package org.maily.repository;


import java.util.List;

import org.maily.model.Mail;

public interface MailRepository {
	
	void saveMail(Mail mail);

	List<Mail> loadInBox(Integer id);

	List<Mail> loadSent(Integer id);

}
