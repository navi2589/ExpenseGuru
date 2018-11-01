/*******************************************************************************
 * Copyright © 2015 - 2017 Praxify Technologies, Inc. All Rights Reserved.
 * NOTICE:  All information contained herein is, and remains the property of Praxify Technologies, Inc. ("Praxify") and its suppliers, if any.  The intellectual and technical concepts contained herein are proprietary to Praxify Technologies, Inc. and its licensors and may be covered by U.S. and Foreign Patents, patents in process, and are protected by trade secret or copyright law. Dissemination of this information or reproduction of this material is strictly forbidden unless prior written permission is obtained from Praxify.
 * No license, express or implied, by estoppel or otherwise to any other Praxify intellectual property right, and no license to any third party technology or intellectual property right, is granted herein, including but not limited to any patent right, copyright, mask work right, or other intellectual property right relating to any combination, machine, or process in which Praxify source files are used. Praxify disclaims all warranties of any kind, implied, statutory, or in any communication between them, including without limitation, the implied warranties of merchantability, non-infringement, title, and fitness for a particular purpose.
 * In no event shall Praxify be liable for any actual, special, incidental, consequential or indirect damages, however caused, including without limitation to the generality of the foregoing, loss of anticipated profits, goodwill, reputation, business receipts or contracts, costs of procurement of substitute goods or services; loss of use, data, or profits; or business interruption, losses or expenses resulting from third party claims. These limitations will apply regardless of the form of action, whether under statute, in contract or tort including negligence or any other form of action and whether or not Praxify has been advised of the possibility of such damages.
 ******************************************************************************/
package com.expenceguru.controllertest;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.expenceguru.controller.UserController;
import com.expenceguru.pojo.PersonContactPojo;
import com.expenceguru.pojo.PersonPojo;
import com.expenceguru.pojo.UserPojo;
import com.expenceguru.services.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	private final String addUpdateUserRequestBody = "{\"userId\":null,\"userName\":\"nchinchore\",\"password\":\"asdf1234\",\"person\":{\"personId\":0,\"fname\":\"navnath\",\"mname\":\"R\",\"lname\":\"Chinchore\",\"prefixId\":6,\"genderId\":3,\"personContacts\":[{\"personContactId\":0,\"contact\":\"8087557408\",\"contactTypeId\":8,\"personId\":0,\"deleted\":false},{\"personContactId\":0,\"contact\":\"nath,chinchore@gmail.com\",\"contactTypeId\":9,\"personId\":0,\"deleted\":false}]}}";
	
	@Test
	public void addNewUserTest() throws Exception {
		
		UserPojo createdUser = getUser();
		Mockito.when(userService.addOrUpdateUser(Mockito.any(UserPojo.class))).thenReturn(createdUser);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/user/add")
				.accept(MediaType.APPLICATION_JSON).content(addUpdateUserRequestBody)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		JSONAssert.assertEquals(getExpectedResponse(), response.getContentAsString() , JSONCompareMode.STRICT);
	}

	private UserPojo getUser() {
		UserPojo user = new UserPojo();
		user.setPassword("asdf1234");
		user.setUserId(1l);
		user.setUserName("nchinchore");
		PersonPojo person = new PersonPojo();
		person.setFname("navnath");
		person.setMname("R");
		person.setGenderId(new Long(3));
		person.setLname("Chinchore");
		person.setPrefixId(6);
		person.setPersonId(1);
		List<PersonContactPojo> personContacts = new ArrayList<>();
		PersonContactPojo contact = new PersonContactPojo();
		contact.setContact("8087557408");
		contact.setContactTypeId(8);
		contact.setPersonContactId(1);
		personContacts.add(contact);
		contact = new PersonContactPojo();
		contact.setContact("nath,chinchore@gmail.com");
		contact.setContactTypeId(9);
		contact.setPersonContactId(2);
		personContacts.add(contact);
		person.setPersonContacts(personContacts);
		user.setPerson(person);
		return user;
	}
	
	private String getExpectedResponse() {
		return "{\"userId\":1,\"userName\":\"nchinchore\",\"password\":\"asdf1234\",\"person\":{\"personId\":1,\"fname\":\"navnath\",\"mname\":\"R\",\"lname\":\"Chinchore\",\"prefixId\":6,\"genderId\":3,\"personContacts\":[{\"personContactId\":1,\"contact\":\"8087557408\",\"contactTypeId\":8,\"personId\":0,\"deleted\":false},{\"personContactId\":2,\"contact\":\"nath,chinchore@gmail.com\",\"contactTypeId\":9,\"personId\":0,\"deleted\":false}]}}";
	}
	
	
	

}
