package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.PersonMapper;
import com.demo.model.Person;
import com.demo.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonMapper personMapper;

	public Person login(String name) {		
		// TODO Auto-generated method stub		
		return personMapper.select(name);	
	
	}
}
