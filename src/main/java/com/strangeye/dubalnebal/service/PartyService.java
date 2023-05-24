package com.strangeye.dubalnebal.service;


import com.strangeye.dubalnebal.dto.Party;

import java.util.List;

public interface PartyService {
	int createParty(Party party);
	Party readParty(int id);
	int updateParty(Party party);
	int deleteParty(int id);

	List<Party> readAll();

}
