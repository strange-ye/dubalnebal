package com.strangeye.dubalnebal.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserMapperTest {

	@Test
	@Transactional
	@Rollback(false)
	void insertUser() {
	}

	@Test
	@Transactional
	@Rollback(false)
	void selectUserByUserIdAndPassword() {
	}

	@Test
	@Transactional
	@Rollback(false)
	void updateUser() {
	}

	@Test
	@Transactional
	@Rollback(false)
	void deleteUser() {
	}
}