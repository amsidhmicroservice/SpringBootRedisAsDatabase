package com.amsidh.mvc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amsidh.mvc.entity.Person;
import com.amsidh.mvc.service.PersonService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {

	private final PersonService personService;

	@PostMapping
	public Person savePerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}

	@GetMapping("/{personId}")
	public Person findPersonById(@PathVariable("personId") Integer personId) {
		return personService.findPersonById(personId);
	}

	@DeleteMapping("/{personId}")
	public String deletePersonById(@PathVariable("personId") Integer personId) {
		return personService.deletePersonById(personId);
	}

	@GetMapping
	public List<Person> getAllPersons() {
		return personService.getAllPersons();
	}
}
