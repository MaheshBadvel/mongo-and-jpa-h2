package com.h2jpa.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2jpa.spring.exception.ResourceNotFoundException;
import com.h2jpa.spring.model.Person;
import com.h2jpa.spring.repository.PersonRepository;
import com.h2jpa.spring.service.PersonService;




@RestController
public class PersonController {
	@Autowired
	PersonService personService;
	@Autowired
	PersonRepository personRepository;
	
//	@PostMapping("/person/add")
//	public Person addPerson(@RequestBody Person person) {
//		return personService.createPerson(person);
//	}
//	
	@PostMapping("/person/add")
	public ResponseEntity<?> addPerson(@RequestBody Person person) {
		try {
			personService.createPerson(person);
			return new ResponseEntity<Person>(person,HttpStatus.OK);
		}catch(ResourceNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
			
		}
	}
	
	@PostMapping("/person/add/all")
	public List<Person> addPersons(@RequestBody List<Person> persons){
		return personService.createPerson(persons);
	}
//	@GetMapping("/person/{id}")
//	public Optional<Person> getPersonById(@PathVariable int id) {
//		return personService.getPersonById(id);
//	}
	@GetMapping("/person/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") int personId)
			throws ResourceNotFoundException {
		Person person =personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));
		return ResponseEntity.ok().body(person);
	}

	@GetMapping("/person/all")
	public List<Person> getAllPersons() {
		return personService.getAllPersons();
	}
//	@PutMapping("update/person")
//	public Person updatePerson(@RequestBody Person person) {
//		return personService.updatePerson(person);
//	}
	@PutMapping("/person/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") int personId,
			@Validated @RequestBody Person personDetails) throws ResourceNotFoundException {
		Person person = personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("person not found for this id :: " + personId));

		
		person.setName(personDetails.getName());
		person.setAddress(personDetails.getAddress());
		final Person updatedPerson = personRepository.save(person);
		return ResponseEntity.ok(updatedPerson);
	}

//	@DeleteMapping("delete/{id}")
//	public String deletePerson(@PathVariable int id) {
//		return personService.deletePerson(id);
//	}
	@DeleteMapping("/person/{id}")
	public Map<String, Boolean> deletePerson(@PathVariable(value = "id") int personId)
			throws ResourceNotFoundException {
		Person person = personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));

		personRepository.delete(person);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@DeleteMapping("delete/all")
	public String removeAllPersons() {
		return personService.removeAllPersons();
	}
	

}
