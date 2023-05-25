package com.strangeye.dubalnebal.service;

import com.strangeye.dubalnebal.dto.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {
	int insertUser(User user, MultipartFile file) throws IOException;
	int deleteUser(String user_identifier);
	int updateUser(User user, MultipartFile file) throws IOException;
	User selectUserByUserIdAndPassword(String user_identifier, String user_password);
	User selectUserByIdentifier(String user_identifier);

}
