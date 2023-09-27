package com.springboot.pagination.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.springboot.pagination.dao.PersonDao;
import com.springboot.pagination.model.CustomType;
import com.springboot.pagination.model.Person;

@Service
public class PersonService {
	
	@Autowired
	private PersonDao personDao;
	
	public List<Person> findByLastName(String lastName,PageRequest paginationObj){
		return personDao.findByLastName(lastName, paginationObj);
	}
	
	public List<CustomType> giveFewColumns(String lastName){
		return personDao.giveFewColumns(lastName);
	}
	
}
