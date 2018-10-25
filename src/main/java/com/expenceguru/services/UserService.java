package com.expenceguru.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenceguru.entites.Person;
import com.expenceguru.entites.User;
import com.expenceguru.exceptions.PersonNotFoundException;
import com.expenceguru.exceptions.UserNotFoundException;
import com.expenceguru.pojo.UserPojo;
import com.expenceguru.repository.PersonRepository;
import com.expenceguru.repository.UserRepository;
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
				person = PersonUtils.populateContact(userInfo.getPerson());
				person = personRepository.save(person);
				user.setPersonId(person.getPersonId());
				user = userRepository.save(user);
					
		} else {
			
			user = UserUtils.populateUser(userInfo);
			Person person  = PersonUtils.populatePerson(userInfo.getPerson());
			person = personRepository.save(person);
			user.setPersonId(person.getPersonId());
			user = userRepository.save(user);
			userInfo.setUserId(user.getUserId());
			userInfo.getPerson().setPersonId((person.getPersonId()));
		}
			return userInfo;
	}

	public List<User> getUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
