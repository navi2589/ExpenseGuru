package com.taxconsultant.services.utils;

import com.taxconsultant.entites.User;
import com.taxconsultant.pojo.UserPojo;

public class UserUtils {

	public static User populateUser(UserPojo user) {
		User userEntity = new User();
		userEntity.setAccountId(user.getAccountId());
		userEntity.setUserId(user.getUserId());
		userEntity.setUser_name(user.getUserName());
		userEntity.setPassword(user.getPassword());
		return userEntity;
	}
}
