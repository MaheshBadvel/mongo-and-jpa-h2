package com.h2jpa.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2jpa.spring.model.Person;
import com.h2jpa.spring.service.PersonService;

@RestController
public class PersonController {
	@Autowired
	PersonService personService;
	
	@PostMapping("/person/add")
	public Person addPerson(@RequestBody Person person) {
		return personService.createPerson(person);
	}
	@PostMapping("/person/add/all")
	public List<Person> addPersons(@RequestBody List<Person> persons){
		return personService.createPerson(persons);
	}
	@GetMapping("/person/{id}")
	public Optional<Person> getPersonById(@PathVariable int id) {
		return personService.getPersonById(id);
	}
	@GetMapping("/person/all")
	public List<Person> getAllPersons() {
		return personService.getAllPersons();
	}
	@PutMapping("update/person")
	public Person updatePerson(@RequestBody Person person) {
		return personService.updatePerson(person);
	}
	@DeleteMapping("delete/{id}")
	public String deletePerson(@PathVariable int id) {
		return personService.deletePerson(id);
	}
	@DeleteMapping("delete/all")
	public String removeAllPersons() {
		return personService.removeAllPersons();
	}
	

}
