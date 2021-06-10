package com.h2jpa.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.h2jpa.spring.model.Person;

@Service
public interface PersonService {
	
	public Person createPerson(Person person);
	
	public List<Person> createPerson(List<Person> persons);
	
	public Optional<Person> getPersonById(int id);
	
	public List<Person> getAllPersons();
	
	public Person updatePerson(Person person);
	
	public String deletePerson(int id); 
	
    public String removeAllPersons();


}
