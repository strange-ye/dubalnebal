package com.strangeye.dubalnebal.controller;

import com.strangeye.dubalnebal.dto.User;
import com.strangeye.dubalnebal.service.BoardService;
import com.strangeye.dubalnebal.service.UserService;
import com.strangeye.dubalnebal.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	UserService userService;
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(User user) {
		Map<String, Object> result = new HashMap<String, Object>();

		// user를 이용해서 Service -> Dao -> DB를 통해 실제 유저인지 확인을 해야한다.
		// 우리는 하지 않겠다. ㅎ 직접 해볼것
		// 아이디가 널이 아니거나 길이가 있거나

		HttpStatus status = null;

		try {
			if (user.getUserIdentifier() != null || user.getUserIdentifier().length() > 0) {
				result.put("access-token", jwtUtil.createToken("id", user.getUserIdentifier()));
				result.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				result.put("message", FAIL);
				status = HttpStatus.NO_CONTENT;
			}
		} catch (UnsupportedEncodingException e) {
			result.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<Map<String, Object>>(result, status);
	}

	@PostMapping("/signup")
	public ResponseEntity<Integer> signup(@RequestBody User user) {
		System.out.println(user);
		int result = userService.insertUser(user);
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}

	@GetMapping("/test")
	public ResponseEntity<?> text() {
		return new ResponseEntity<>("hi", HttpStatus.ACCEPTED);
	}
}
