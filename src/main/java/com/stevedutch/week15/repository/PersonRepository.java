package com.stevedutch.week15.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Map.Entry;

import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.stevedutch.week15.domain.Person;


@Repository
public class PersonRepository {
	private Map<Integer, Person> people = new HashMap<>();
	
	public Person save (Person person) {
		people.put(person.getId(), person);
		return person;
	}
	
	public Person findById (Integer personId) {
		return people.get(personId);
	}

	@Override
	public String toString() {
		return "PersonRepository [people=" + people + "]";
	}

	public List<Person> findAll() {
		return people.entrySet()
					 .stream()
					 .map(Entry::getValue)
					 .collect(Collectors.toList());
	}

	public void delete(Integer personId2) {
		people.remove(personId2);
		
	}

}
