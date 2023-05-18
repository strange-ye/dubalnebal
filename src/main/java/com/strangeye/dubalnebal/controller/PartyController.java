package com.strangeye.dubalnebal.controller;

import com.strangeye.dubalnebal.dto.Party;
import com.strangeye.dubalnebal.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartyController {
	@Autowired
	PartyService partyService;

	@PostMapping("/party")
	public ResponseEntity<Integer> write(Party party){
		int result = partyService.writeParty(party);

		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}
}
