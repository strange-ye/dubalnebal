package com.strangeye.dubalnebal.controller;

import com.strangeye.dubalnebal.dto.Party;
import com.strangeye.dubalnebal.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PartyController {
	@Autowired
	PartyService partyService;

	// 파티 생성
	@PostMapping("/party")
	public ResponseEntity<Integer> write(Party party){
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

}
