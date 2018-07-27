package com.taxconsultant.services.utils;

import com.taxconsultant.entites.Person;
import com.taxconsultant.pojo.PersonPojo;

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

}
