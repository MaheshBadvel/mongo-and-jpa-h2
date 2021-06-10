package com.h2jpa.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2jpa.spring.model.Person;
import com.h2jpa.spring.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	PersonRepository personRepository;
	
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}
	
	public List<Person> createPerson(List<Person> persons){
		return personRepository.saveAll(persons);
	}
	
	public Optional<Person> getPersonById(int id) {
		return personRepository.findById(id);
	}
	
	public List<Person> getAllPersons(){
		return personRepository.findAll();
		
	}
	
	public Person updatePerson(Person person) {
		return personRepository.save(person);
	}
	public String deletePerson(int id) {
		personRepository.deleteById(id);
		return "Person deleted";
	}
    public String removeAllPersons() {
    	
    	personRepository.deleteAll();
    	return "All Persons are Removed";
	}

}
