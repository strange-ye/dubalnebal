package com.strangeye.dubalnebal.service;

import com.strangeye.dubalnebal.dao.UserDao;
import com.strangeye.dubalnebal.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Service
public class UserServiceImpl implements  UserService{
	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public int insertUser(User user, MultipartFile file) throws IOException {
		String projectPath = "/Users/sangholee/Github/dubalnebal-front/public/image";
		System.out.println(projectPath);
		UUID uuid = UUID.randomUUID(); //식별자 랜덤 이름 만들어줌

		String fileName = uuid + "_" + file.getOriginalFilename();
		File saveDirectory = new File(projectPath);
		if (!saveDirectory.exists()) {
			saveDirectory.mkdirs(); // 디렉토리가 존재하지 않으면 생성합니다.
		}
		File saveFile = new File(projectPath, fileName);
		System.out.println(projectPath);
		file.transferTo(saveFile);
		user.setUser_image(fileName);

		return userDao.insertUser(user);
	}

	@Override
	@Transactional
	public int deleteUser(String user_identifier) {
		return userDao.deleteUser(user_identifier);
	}

	@Override
	@Transactional
	public int updateUser(User user, MultipartFile file) throws IOException {
		String projectPath = "/Users/sangholee/Github/dubalnebal-front/public/image";
		System.out.println(projectPath);
		UUID uuid = UUID.randomUUID(); //식별자 랜덤 이름 만들어줌

		String fileName = uuid + "_" + file.getOriginalFilename();
		File saveDirectory = new File(projectPath);
		if (!saveDirectory.exists()) {
			saveDirectory.mkdirs(); // 디렉토리가 존재하지 않으면 생성합니다.
		}
		File saveFile = new File(projectPath, fileName);
		System.out.println(projectPath);
		file.transferTo(saveFile);
		user.setUser_image(fileName);

		return userDao.updateUser(user);
	}

	@Override
	@Transactional
	public User selectUserByUserIdAndPassword(String user_identifier, String user_password) {
		return userDao.selectUserByUserIdAndPassword(user_identifier, user_password);
	}

	@Override
	@Transactional
	public User selectUserByIdentifier(String user_identifier) {
		return userDao.selectUserByIdentifier(user_identifier);
	}

}
