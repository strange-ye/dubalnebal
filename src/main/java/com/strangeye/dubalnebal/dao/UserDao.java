package com.strangeye.dubalnebal.dao;

import com.strangeye.dubalnebal.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

	// 사용자 추가
	int insertUser(User user);
	// 로그인 아이디와 비밀번호로 사용자 정보를 가져온다. 로그인 시에 사용
	User selectUserByUserIdAndPassword(String user_identifier, String user_password);
	// 사용자 정보를 새로운 내용으로 업데이트
	int updateUser(User user);
	// 회원탈퇴
	int deleteUser(String user_identifier);
	// 로그인 아이디로 사용자 정보를 가져온다.
	User selectUserByIdentifier(String user_identifier);

}
