package com.strangeye.dubalnebal.controller;

import com.strangeye.dubalnebal.dto.Party;
import com.strangeye.dubalnebal.dto.Party_User;
import com.strangeye.dubalnebal.dto.User;
import com.strangeye.dubalnebal.service.PartyService;
import com.strangeye.dubalnebal.service.PartyUserService;
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
public class PartyController {
	@Autowired
	PartyService partyService;

	@Autowired
	private UserService userService;

	@Autowired
	private PartyUserService partyUserService;

	@Autowired
	JwtUtil jwtUtil;
	// 파티 생성
	@PostMapping("/party")
	public ResponseEntity<Integer> write(@RequestBody Party party, HttpServletRequest request) throws UnsupportedEncodingException {
		System.out.println(party);
		String token = request.getHeader("HEADER_AUTH");
		Claims claims = jwtUtil.decodeToken(token);

		String claimId = "id";
		String user_identifier= claims.get(claimId, String.class);
		System.out.println(user_identifier);
		User user_found = userService.selectUserByIdentifier(user_identifier);

		System.out.println(user_found);
		party.setUser_id(user_found.getUser_id());
		int result = partyService.createParty(party);

		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	// id로 파티 정보 가져오기
	@GetMapping("/party/{id}")
	public ResponseEntity<Party> read(@PathVariable int id) {

		return new ResponseEntity<>(partyService.readParty(id), HttpStatus.OK);
	}

	// 정보를 받아서 파티 데이터를 업데이트
	@PostMapping("/party/update")
	public ResponseEntity<Integer> update(Party party){
		int result = partyService.updateParty(party);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	// id에 맞는 파티를 삭제
	@PostMapping("/party/delete/{id}")
	public ResponseEntity<Integer> update(@PathVariable int id){
		int result = partyService.deleteParty(id);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	// 모든 파티 찾아오기
	@GetMapping("/party")
	public ResponseEntity<List<Party>> readAll() {
		List<Party> list = partyService.readAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// 파티 참여
	@PostMapping("party/{party_id}")
	public ResponseEntity<Integer> participate(@PathVariable int party_id, HttpServletRequest request) throws UnsupportedEncodingException {
		String token = request.getHeader("HEADER_AUTH");
		Claims claims = jwtUtil.decodeToken(token);

		String claimId = "id";
		String user_identifier= claims.get(claimId, String.class);
		User user_found = userService.selectUserByIdentifier(user_identifier);
		int user_id = user_found.getUser_id();

		Party_User partyUser = new Party_User(party_id, user_id);
		int result = partyUserService.participateParty(partyUser);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	// 현재 참여자 수 구하기
	@GetMapping("party/{party_id}")
	public ResponseEntity<Integer> countParticipant(@PathVariable int party_id) {
		int result = partyService.getParticipantNumber(party_id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
