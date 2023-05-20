package com.strangeye.dubalnebal.service;

import com.strangeye.dubalnebal.dao.UserDao;
import com.strangeye.dubalnebal.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements  UserService{
	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

	@Override
	@Transactional
	public int deleteUser(String user_identifier) {
		return userDao.deleteUser(user_identifier);
	}

	@Override
	@Transactional
	public int updateUser(User user) {
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
