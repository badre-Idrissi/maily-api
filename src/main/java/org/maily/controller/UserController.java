package org.maily.controller;

import java.util.List;

import org.maily.model.Mail;
import org.maily.model.User;
import org.maily.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.POST)
	public void save(@RequestBody User user) {
		userService.save(user);
	}
	
	@RequestMapping(value="{id}/sendmail", method=RequestMethod.POST)
	public void sendMail(@PathVariable Integer id, @RequestBody Mail mail) {
		userService.sendMail(id, mail);
	}
	
	@RequestMapping(value="{id}/inbox", method=RequestMethod.GET)
	public List<Mail> inbox(@PathVariable Integer id) {
		return userService.loadInBox(id);
	}
	
	@RequestMapping(value="{id}/sent", method=RequestMethod.GET)
	public List<Mail> sent(@PathVariable Integer id) {
		return userService.loadSent(id);
	}
	
	

}
