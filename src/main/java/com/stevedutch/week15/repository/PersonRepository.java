package com.stevedutch.week15.repository;

import java.util.HashMap;
import java.util.Map;

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

}
