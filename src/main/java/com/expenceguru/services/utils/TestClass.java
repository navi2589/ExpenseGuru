/*******************************************************************************
 * Copyright © 2015 - 2017 Praxify Technologies, Inc. All Rights Reserved.
 * NOTICE:  All information contained herein is, and remains the property of Praxify Technologies, Inc. ("Praxify") and its suppliers, if any.  The intellectual and technical concepts contained herein are proprietary to Praxify Technologies, Inc. and its licensors and may be covered by U.S. and Foreign Patents, patents in process, and are protected by trade secret or copyright law. Dissemination of this information or reproduction of this material is strictly forbidden unless prior written permission is obtained from Praxify.
 * No license, express or implied, by estoppel or otherwise to any other Praxify intellectual property right, and no license to any third party technology or intellectual property right, is granted herein, including but not limited to any patent right, copyright, mask work right, or other intellectual property right relating to any combination, machine, or process in which Praxify source files are used. Praxify disclaims all warranties of any kind, implied, statutory, or in any communication between them, including without limitation, the implied warranties of merchantability, non-infringement, title, and fitness for a particular purpose.
 * In no event shall Praxify be liable for any actual, special, incidental, consequential or indirect damages, however caused, including without limitation to the generality of the foregoing, loss of anticipated profits, goodwill, reputation, business receipts or contracts, costs of procurement of substitute goods or services; loss of use, data, or profits; or business interruption, losses or expenses resulting from third party claims. These limitations will apply regardless of the form of action, whether under statute, in contract or tort including negligence or any other form of action and whether or not Praxify has been advised of the possibility of such damages.
 ******************************************************************************/
package com.expenceguru.services.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.expenceguru.pojo.PersonContactPojo;
import com.expenceguru.pojo.PersonPojo;
import com.expenceguru.pojo.UserPojo;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import springfox.documentation.spring.web.json.Json;

public class TestClass {
	
	public static void main(String[] args) throws JsonProcessingException {
		UserPojo user = new UserPojo();
		user.setPassword("asdf1234");
		user.setUserName("nchinchore");
		PersonPojo person = new PersonPojo();
		person.setFname("navnath");
		person.setMname("R");
		person.setGenderId(new Long(3));
		person.setLname("Chinchore");
		person.setPrefixId(6);
		List<PersonContactPojo> personContacts = new ArrayList<>();
		PersonContactPojo contact = new PersonContactPojo();
		contact.setContact("8087557408");
		contact.setContactTypeId(8);
		personContacts.add(contact);
		contact = new PersonContactPojo();
		contact.setContact("nath,chinchore@gmail.com");
		contact.setContactTypeId(9);
		personContacts.add(contact);
		person.setPersonContacts(personContacts);
		user.setPerson(person);
	
		ObjectMapper mapper = new ObjectMapper();
		

		

		//Object to JSON in String
		String jsonInString = mapper.writeValueAsString(user);
		System.out.println(jsonInString);
		
	}

}
