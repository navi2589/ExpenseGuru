package com.expenceguru.services.utils;

import com.expenceguru.entites.User;
import com.expenceguru.pojo.UserPojo;

public class UserUtils {

	public static User populateUser(UserPojo user) {
		User userEntity = new User();
		userEntity.setUserId(user.getUserId());
		userEntity.setUser_name(user.getUserName());
		userEntity.setPassword(user.getPassword());
		return userEntity;
	}
}
