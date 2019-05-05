package com.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.model.Person;
import com.demo.service.PersonService;

@Controller
@RequestMapping("/user")
public class MainController {
	
	Logger logger = Logger.getLogger(MainController.class);
	
	@Autowired
	private PersonService testService;

	@RequestMapping(value = "/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") int password,
			HttpServletRequest request) {
		logger.info("username=" + username + "  password=" + password);
		Person person = testService.login(username);
		if (person == null) {
			logger.info("not found");
		}
		logger.info("password = " + person.getPassword());
		if (password == Integer.parseInt(person.getPassword())) {
			logger.info("this user is exist");
			return "loginSuccess";
		} else {
			logger.info("this user is not exist");
			return "loginFail";
		}
	}
	
	
}
