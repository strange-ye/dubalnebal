package com.strangeye.dubalnebal.service;

import com.strangeye.dubalnebal.dao.PartyDao;
import com.strangeye.dubalnebal.dto.Party;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyServiceImpl implements PartyService{
	@Autowired
	PartyDao partyDao;

	@Override
	public int writeParty(Party party) {
		return partyDao.writeParty(party);
	}
}
