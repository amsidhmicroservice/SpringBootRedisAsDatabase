package com.amsidh.mvc.service;

import java.util.List;

import com.amsidh.mvc.entity.Person;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

public interface PersonService {

	@Cacheable(value = "person")
	Person savePerson(Person person);

	List<Person> getAllPersons();

	@Cacheable(value = "person", unless = "#result.id >2")
	Person findPersonById(Integer personId);

	@CacheEvict(value = "person")
	String deletePersonById(Integer personId);
}
