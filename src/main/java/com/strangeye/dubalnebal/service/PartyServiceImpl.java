package com.strangeye.dubalnebal.service;

import com.strangeye.dubalnebal.dao.PartyDao;
import com.strangeye.dubalnebal.dto.Party;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyServiceImpl implements PartyService{
	@Autowired
	PartyDao partyDao;

	@Override
	public int createParty(Party party) {
		return partyDao.writeParty(party);
	}


	@Override
	public Party readParty(int party_id) {
		return partyDao.selectParty(party_id);
	}

	@Override
	public int updateParty(Party party) {
		return partyDao.updateParty(party);
	}

	@Override
	public int deleteParty(int party_id) {
		return partyDao.deleteParty(party_id);
	}

	@Override
	public List<Party> readAll() {
		return partyDao.selectAll();
	}

	@Override
	public int getParticipantNumber(int party_id) {
		return partyDao.count(party_id);
	}

}
