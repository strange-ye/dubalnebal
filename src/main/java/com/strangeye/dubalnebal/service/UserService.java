package com.strangeye.dubalnebal.service;

import com.strangeye.dubalnebal.dto.User;

public interface UserService {
	int insertUser(User user);
	int deleteUser(String user_identifier);
	int updateUser(User user);
	User selectUserByUserIdAndPassword(String user_identifier, String user_password);
	User selectUserByIdentifier(String user_identifier);

	User selectUserByIdentifier(String user_identifier);
}
