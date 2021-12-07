package com.amsidh.mvc.service;

import java.util.List;

import com.amsidh.mvc.entity.Person;

public interface PersonService {
	Person savePerson(Person person);

	List<Person> getAllPersons();

	Person findPersonById(Integer personId);

	String deletePersonById(Integer personId);
}
