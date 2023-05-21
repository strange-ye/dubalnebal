package com.strangeye.dubalnebal.controller;

import com.strangeye.dubalnebal.dto.User;
import com.strangeye.dubalnebal.service.UserService;
import com.strangeye.dubalnebal.util.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
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

	// 로그인. 사용자 정보를 받아서 db에 추가한다.
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
		Map<String, Object> result = new HashMap<String, Object>();

		// user를 이용해서 Service -> Dao -> DB를 통해 실제 유저인지 확인을 해야한다.
		// 우리는 하지 않겠다. ㅎ 직접 해볼것
		// 아이디가 널이 아니거나 길이가 있거나

		HttpStatus status = null;

		try {
			if (user.getUser_identifier() != null || user.getUser_identifier().length() > 0) {
				result.put("access-token", jwtUtil.createToken("id", user.getUser_identifier()));
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

	// 회원가입. 사용자 정보를 받아서 회원가입한다.
	@PostMapping("/signup")
	public ResponseEntity<Integer> signup(@RequestBody User user) {
		int result = userService.insertUser(user);
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}

	// 기존에 존재하는 사용자의 데이터를 업데이트 해준다.
	@PostMapping("/update")
	public ResponseEntity<Integer> update(@RequestBody User user, HttpServletRequest request) throws UnsupportedEncodingException {
		String token = request.getHeader("HEADER_AUTH");
		Claims claims = jwtUtil.decodeToken(token);

		String claimId = "id";
		String user_identifier= claims.get(claimId, String.class);
		user.setUser_identifier(user_identifier);

		int result = userService.updateUser(user);
		return new ResponseEntity<Integer>(result, HttpStatus.ACCEPTED);
	}

	// 로그인 된 사용자 정보 삭제
	@PostMapping("/delete")
	public ResponseEntity<Integer> delete(HttpServletRequest request) throws UnsupportedEncodingException {
		String token = request.getHeader("HEADER_AUTH");
		Claims claims = jwtUtil.decodeToken(token);

		String claimId = "id";
		String user_identifier= claims.get(claimId, String.class);

		int result = userService.deleteUser(user_identifier);
		return new ResponseEntity<Integer>(result, HttpStatus.ACCEPTED);
	}

}