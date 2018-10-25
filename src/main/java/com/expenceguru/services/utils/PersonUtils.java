package com.expenceguru.services.utils;

import com.expenceguru.entites.Person;
import com.expenceguru.entites.PersonContact;
import com.expenceguru.pojo.PersonPojo;

public class PersonUtils {
	
	public static Person populatePerson(PersonPojo person) {
		
		Person personEntiy = new Person();
		personEntiy.setFname(person.getFname());
		personEntiy.setLname(person.getLname());
		personEntiy.setMname(person.getMname());
		personEntiy.setGenderId(person.getGenderId());
		personEntiy.setPrefoxId(person.getPrefixId());
		personEntiy.setPersonId(person.getPersonId());	
		return personEntiy;
		
	}

	public static PersonContact populateContact(PersonPojo person) {
		// TODO Auto-generated method stub
		return null;
	}

}
