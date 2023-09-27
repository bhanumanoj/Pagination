package com.springboot.pagination.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.pagination.model.CustomType;
import com.springboot.pagination.model.Person;

@Repository
public interface PersonDao extends JpaRepository<Person,Integer> {
	public List<Person> findByLastName(String lastName,Pageable paginationObj);
	public List<CustomType> giveFewColumns(String lastName);
}
