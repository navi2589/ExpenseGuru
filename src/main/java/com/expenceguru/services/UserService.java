package com.expenceguru.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenceguru.entites.Person;
import com.expenceguru.entites.PersonContact;
import com.expenceguru.entites.User;
import com.expenceguru.exceptions.PersonNotFoundException;
import com.expenceguru.exceptions.UserNotFoundException;
import com.expenceguru.pojo.UserPojo;
import com.expenceguru.repository.PersonRepository;
import com.expenceguru.repository.UserRepository;
import com.expenceguru.services.utils.PersonContactUtils;
import com.expenceguru.services.utils.PersonUtils;
import com.expenceguru.services.utils.UserUtils;
import com.fasterxml.jackson.annotation.JsonCreator;

import springfox.documentation.spring.web.json.Json;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	PersonContactService personContactService;
	
	@Autowired 
	private PersonService personService;
	
	@Transactional
	public UserPojo addOrUpdateUser (UserPojo userInfo) throws PersonNotFoundException, UserNotFoundException {
			User user = null;
			
			if (userInfo.getUserId() != null) {
				
				Optional<User> userEntity = userRepository.findById(userInfo.getUserId());
				if (!userEntity.isPresent()) 
					throw new UserNotFoundException("User not present with userId" + userInfo.getUserId());
			
				user = userEntity.get();
				userInfo.setUserId(user.getUserId());
				user = UserUtils.populateUser(userInfo);
				Optional<Person> personEntity = personRepository.findById(userInfo.getPerson().getPersonId());
				if (!personEntity.isPresent()) 
					throw new PersonNotFoundException("Person not present with userId" + userInfo.getPerson().getPersonId());
			
				Person person = personEntity.get();
				userInfo.getPerson().setPersonId(person.getPersonId());
				person = PersonUtils.populatePerson(userInfo.getPerson());
				person = personRepository.save(person);
				Long personId = person.getPersonId();
				if(userInfo.getPerson().getPersonContacts() != null && !userInfo.getPerson().getPersonContacts().isEmpty() ) {
					userInfo.getPerson().getPersonContacts().forEach(personcontact -> {
						personcontact.setPersonId(personId);
						PersonContact contact = personContactService.addOrUpdatePersonContact(PersonContactUtils.populatePersonContact(personcontact));
						personcontact.setPersonContactId(contact.getPersonContactId());
					});					
				}
				user.setPersonId(person.getPersonId());
				user = userRepository.save(user);
				userInfo.setUserId(user.getUserId());
					
		} else {
			
			user = UserUtils.populateUser(userInfo);
			Person person  = PersonUtils.populatePerson(userInfo.getPerson());
			person = personRepository.save(person);
			user.setPersonId(person.getPersonId());
			long personId = person.getPersonId();
			if(userInfo.getPerson().getPersonContacts() != null && !userInfo.getPerson().getPersonContacts().isEmpty() ) {
				userInfo.getPerson().getPersonContacts().forEach(personcontact -> {
					personcontact.setPersonId(personId);
					PersonContact contact = personContactService.addOrUpdatePersonContact(PersonContactUtils.populatePersonContact(personcontact));
					personcontact.setPersonContactId(contact.getPersonContactId());
				});					
			}
			user = userRepository.save(user);
			userInfo.setUserId(user.getUserId());
			userInfo.getPerson().setPersonId((person.getPersonId()));
		}
			return userInfo;
	}

	public List<User> getUser(int userId) {
		
		return null;
	}
	
}
