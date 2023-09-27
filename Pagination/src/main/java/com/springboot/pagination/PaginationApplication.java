package com.springboot.pagination;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import com.springboot.pagination.model.CustomType;
import com.springboot.pagination.model.Person;
import com.springboot.pagination.service.PersonService;

@SpringBootApplication
public class PaginationApplication implements CommandLineRunner {
	
	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(PaginationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		giveFewColumns();
		dispPagination();
	}

	private void dispPagination() {
		// TODO Auto-generated method stub
		System.out.println("Pagination without sorting");
		
//		List<Person> noSortList=personService.findByLastName("Kumar", PageRequest.of(0, 4));
//		noSortList.forEach(System.out::println);
		
		System.out.println("First Page -------");
		Iterable<Person> list= personService.findByLastName("Kumar", PageRequest.of(0, 2, Direction.ASC,"firstName"));
		list.forEach(System.out::println);
		
		System.out.println("Second Page -------");
		Iterable<Person> secondList= personService.findByLastName("Kumar", PageRequest.of(1, 2, Direction.ASC,"firstName"));
		secondList.forEach(System.out::println);
		
		System.out.println("Third Page -------");
		Iterable<Person> thirdList= personService.findByLastName("Kumar", PageRequest.of(2, 2, Direction.ASC,"firstName"));
		thirdList.forEach(System.out::println);
		System.out.println("exit");
		
	}
		private void giveFewColumns() {
			Iterable<CustomType> personsList = personService.giveFewColumns("Kumar");
			for (CustomType person : personsList) {
				System.out.println("Person Object" + person.toString());

			}
		}
		
	
}
