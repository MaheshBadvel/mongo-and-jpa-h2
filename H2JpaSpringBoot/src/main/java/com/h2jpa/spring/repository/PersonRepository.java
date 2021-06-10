package com.h2jpa.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.h2jpa.spring.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
