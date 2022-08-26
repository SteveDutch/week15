package com.stevedutch.week15.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stevedutch.week15.domain.Person;
import com.stevedutch.week15.repository.PersonRepository;

@Service
public class PersonService {
	
	private Integer personId = 1;
	@Autowired
	private PersonRepository personRepo;
	
	public Person save(Person person) {
		if (person.getId() == null)
		person.setId(personId++);
		System.out.println(personRepo + "from PersonService.save");
		return personRepo.save(person);
	}

	public Person findById(Integer personId) {
		return personRepo.findById(personId);
	}


}
