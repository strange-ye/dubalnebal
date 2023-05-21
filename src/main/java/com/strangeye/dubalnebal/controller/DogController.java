package com.strangeye.dubalnebal.controller;

import com.strangeye.dubalnebal.dto.Dog;
import com.strangeye.dubalnebal.dto.Party;
import com.strangeye.dubalnebal.service.DogService;
import com.strangeye.dubalnebal.service.PartyService;
import com.strangeye.dubalnebal.service.UserService;
import com.strangeye.dubalnebal.util.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DogController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	DogService dogService;

	@Autowired
	UserService userService;

	@GetMapping("/dog/{dog_id}")
	public ResponseEntity<List<Dog>> get(@PathVariable int dog_id) {
		List<Dog> list = dogService.getDog(dog_id);

		return new ResponseEntity<>(list, HttpStatus.CREATED);
	}

	@PostMapping("/dog")
	public ResponseEntity<Boolean> write(@RequestBody Dog dog, HttpServletRequest request) throws UnsupportedEncodingException {
		String token = request.getHeader("HEADER_AUTH");
		Claims claims = jwtUtil.decodeToken(token);

		String claimId = "id";
		String user_identifier = claims.get(claimId, String.class);
		int user_id = userService.selectUserByIdentifier(user_identifier).getUser_id();
		Boolean result = dogService.writeDog(dog, user_identifier);

		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	@PutMapping("/dog/update")
	public ResponseEntity<Boolean> modify(@RequestBody Dog dog, HttpServletRequest request) throws UnsupportedEncodingException {
		String token = request.getHeader("HEADER_AUTH");
		Claims claims = jwtUtil.decodeToken(token);

		String claimId = "id";
		String user_identifier = claims.get(claimId, String.class);
		int user_id = userService.selectUserByIdentifier(user_identifier).getUser_id();
		// dog에 user_id 추가하는 코드
		Boolean result = dogService.modifyDog(dog);

		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	@DeleteMapping("/dog/delete/{dog_id}")
	public ResponseEntity<Boolean> remove(@PathVariable int dog_id, HttpServletRequest request) throws UnsupportedEncodingException {
		String token = request.getHeader("HEADER_AUTH");
		Claims claims = jwtUtil.decodeToken(token);

		String claimId = "id";
		String user_identifier = claims.get(claimId, String.class);
		int user_id = userService.selectUserByIdentifier(user_identifier).getUser_id();

		// id로 개를 가져와서 주인의 아이디와 일치하는지 확인
		boolean result = dogService.removeDog(dog_id);

		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

}