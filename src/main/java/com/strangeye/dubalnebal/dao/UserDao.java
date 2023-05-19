package com.strangeye.dubalnebal.dao;

import com.strangeye.dubalnebal.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserDao {

	int insertUser(User user);
	User selectUserByUserIdAndPassword(String user_identifier, String user_password);
	int updateUser(User user);
	int deleteUser(String user);

}
