package com.strangeye.dubalnebal.controller;

import com.strangeye.dubalnebal.dto.User;
import com.strangeye.dubalnebal.service.BoardService;
import com.strangeye.dubalnebal.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	private JwtUtil jwtUtil;
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private BoardService boardService;

	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(User user) {
		Map<String, Object> result = new HashMap<String, Object>();

		HttpStatus status = null;

		try {
			if (user.getId() != null || user.getUserId().length() > 0) {
				result.put("access-token", jwtUtil.createToken("id", user.getUserId()));
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
}
