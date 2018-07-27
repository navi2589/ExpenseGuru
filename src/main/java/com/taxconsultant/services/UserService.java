package com.taxconsultant.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.taxconsultant.entites.Person;
import com.taxconsultant.entites.User;
import com.taxconsultant.exceptions.PersonNotFoundException;
import com.taxconsultant.exceptions.UserNotFoundException;
import com.taxconsultant.pojo.UserPojo;
import com.taxconsultant.repository.PersonRepository;
import com.taxconsultant.repository.UserRepository;
import com.taxconsultant.services.utils.PersonUtils;
import com.taxconsultant.services.utils.UserUtils;

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

	public List<User> getAaccountUsers(int accountId) {
		return null;
	}

	public List<User> getUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
