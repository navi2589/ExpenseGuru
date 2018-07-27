package com.taxconsultant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taxconsultant.entites.User;
import com.taxconsultant.exceptions.PersonNotFoundException;
import com.taxconsultant.exceptions.UserNotFoundException;
import com.taxconsultant.pojo.UserPojo;
import com.taxconsultant.services.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired 
	private UserService userService;
	
	@RequestMapping(path = "/{accountId}",  method = RequestMethod.GET) 
	@ApiOperation("Returns list of user those are belong to the passed in account Id.")
	public List<User> getAaccountUsers(@ApiParam("accountId of which user will be returned. Cannot be empty.") @PathVariable("accountId") int accountId){

		return userService.getAaccountUsers(accountId) ;
	}
	
	@RequestMapping(path = "/{userId}",  method = RequestMethod.GET) 
	@ApiOperation("Returns user details for provided user id.")
	public List<User> getUser(@ApiParam("userId of the user to be obtained. Cannot be empty.") @PathVariable("userId") int userId){

		return userService.getUser(userId ) ;
	}
	
	@RequestMapping(path =  "/add", method = RequestMethod.POST)
	@ApiOperation("add or update account user with provided details.")
	public UserPojo addOrUpdateUser(@ApiParam("User information which needs to added or updated") @RequestBody UserPojo user) throws PersonNotFoundException, UserNotFoundException{
		
		return userService.addOrUpdateUser(user);
		
	}

}
