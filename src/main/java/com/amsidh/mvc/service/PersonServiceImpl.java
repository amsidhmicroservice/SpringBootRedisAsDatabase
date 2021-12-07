package com.amsidh.mvc.service;

import java.util.List;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.amsidh.mvc.entity.Person;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

	private final RedisTemplate redisTemplate;
	private static final String HASH_KEY = "Person";

	@Override
	public Person savePerson(Person person) {
		redisTemplate.opsForHash().put(HASH_KEY, person.getId(), person);
		return person;
	}

	@Override
	public List<Person> getAllPersons() {
		return redisTemplate.opsForHash().values(HASH_KEY);
	}

	@Override
	public Person findPersonById(Integer personId) {
		return (Person) redisTemplate.opsForHash().get(HASH_KEY, personId);
	}

	@Override
	public String deletePersonById(Integer personId) {
		redisTemplate.opsForHash().delete(HASH_KEY, personId);
		return String.format("Person with id {} deleted successfully", personId);
	}

}
