package com.stevedutch.week15.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.stevedutch.week15.domain.Person;
import com.stevedutch.week15.service.PersonService;

@Controller
public class MyFirstPersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("")
	public String getMyFirstRootWebpage(ModelMap model) {
		// firstName muß im Mapping stehen, sonst null
		String firstName = "me";
		// Modelmap comes from Spring and is a linked Hashmap ("extends LinkedHashMap")
		model.put("firstName", firstName);
		//   This is what gets returned / resolved when we
			//     return a String inside of a regular Controller GetMapping method
			//   /src/main/resources/templates/welcome.html
		Person person = new Person();
		model.put("person", person);
		return "people";
	}
	
	@GetMapping("/persons")
	public String getpeople(ModelMap model) {
		String firstName = "me";
		// Modelmap comes from Spring and is a linked Hashmap ("extends LinkedHashMap")
		model.put("firstName", firstName);
		//   This is what gets returned / resolved when we
			//     return a String inside of a regular Controller GetMapping method
			//   /src/main/resources/templates/welcome.html
		Person person = new Person();
		model.put("person", person);
		return "people";
	}
	
	@PostMapping("/persons")
	public String postPeople (Person person) {
		Person savedPerson = personService.save(person);
		System.out.println(savedPerson + "\n  from PostMapping persons");
		
		return "redirect:/persons";
		
	}
	
	@GetMapping("/persons/{personId}")
	// not sure why, but without ModelMap it's not working
	public String getPerson (@PathVariable Integer personId, ModelMap model) {
		Person person = personService.findById(personId);
		model.put("person", person);
		return "people";
		
	}

	@PostMapping("/persons/{personId}")
	public String postPerson (Person person) {
		Person savedPerson = personService.save(person);
		System.out.println(savedPerson + "\n  from PostMapping persons/{personId}");
		return "redirect:/persons/" + savedPerson.getId();
		
	}
	
	@PostMapping("")
	public String postRootWebpage (Person person) {
		Person savedPerson = personService.save(person);
		System.out.println(savedPerson + "\n  from PostMapping \"\"");
		
		return "redirect:/";
		
	}

}
