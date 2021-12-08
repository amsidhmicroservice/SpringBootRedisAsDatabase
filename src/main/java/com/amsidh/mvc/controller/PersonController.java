package com.amsidh.mvc.controller;

import com.amsidh.mvc.entity.Person;
import com.amsidh.mvc.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/person")
@Slf4j
public class PersonController {

	private final PersonService personService;

	@PostMapping
	public Person savePerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}

	@GetMapping("/{personId}")
	@Cacheable(key = "#personId", value = "Person", unless = "#result.id >2")
	public Person findPersonById(@PathVariable("personId") Integer personId) {
	    log.info("Inside findPersonById method of PersonController");
		return personService.findPersonById(personId);
	}

	@DeleteMapping("/{personId}")
	@CacheEvict(key = "#personId", value = "Person")
	public String deletePersonById(@PathVariable("personId") Integer personId) {
		return personService.deletePersonById(personId);
	}

	@GetMapping
	public List<Person> getAllPersons() {
		return personService.getAllPersons();
	}
}
