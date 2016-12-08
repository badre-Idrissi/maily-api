package org.maily.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="t_mail")
public class Mail {
	
	@Id
	@GeneratedValue(generator = "SEC_MAIL", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEC_MAIL", sequenceName = "t_mail_id_seq",allocationSize=1)
	private Integer id;
	private String subject;
	private String body;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User sender;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="t_mail_user")
	private List<User> receivers;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@JsonIgnore
	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public List<User> getReceivers() {
		return receivers;
	}

	public void setReceivers(List<User> receivers) {
		this.receivers = receivers;
	}

}
