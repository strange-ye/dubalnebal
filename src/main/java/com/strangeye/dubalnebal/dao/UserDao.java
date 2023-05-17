package com.strangeye.dubalnebal.dao;

import com.strangeye.dubalnebal.dto.User;

public interface UserDao {

	int insertUser(User user);
	User selectUserByUserIdAndPassword(User user);
	int updateUser(User user);
	int deleteUser(User user);

}
