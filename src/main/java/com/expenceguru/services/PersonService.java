package com.expenceguru.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenceguru.entites.Person;
import com.expenceguru.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person addOrUpdatePerson(Person person) {
		
		personRepository.save(person);
		return person;
		
		
		
	}

}
