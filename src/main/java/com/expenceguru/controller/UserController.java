package com.expenceguru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.expenceguru.entites.User;
import com.expenceguru.exceptions.PersonNotFoundException;
import com.expenceguru.exceptions.UserNotFoundException;
import com.expenceguru.pojo.UserPojo;
import com.expenceguru.services.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired 
	private UserService userService;
	
	@RequestMapping(path = "/{userId}",  method = RequestMethod.GET, produces = {"application/JSON"}) 
	@ApiOperation("Returns user details for provided user id.")
	public List<User> getUser(@ApiParam("userId of the user to be obtained. Cannot be empty.") @PathVariable("userId") int userId){

		return userService.getUser(userId ) ;
	}
	
	@RequestMapping(path =  "/add", method = RequestMethod.POST, produces = {"application/JSON"})
	@ApiOperation("add or update account user with provided details.")
	public @ResponseBody UserPojo addOrUpdateUser(@ApiParam("User information which needs to added or updated") @RequestBody UserPojo user) throws PersonNotFoundException, UserNotFoundException{
		
		return userService.addOrUpdateUser(user);
		
	}

}
