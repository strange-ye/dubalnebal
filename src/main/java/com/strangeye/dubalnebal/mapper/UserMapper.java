package com.strangeye.dubalnebal.mapper;

import com.strangeye.dubalnebal.domain.User;

public interface UserMapper {

	int insertUser(User user);
	User selectUserByUserIdAndPassword(User user);
	int updateUser(User user);
	int deleteUser(User user);

}
