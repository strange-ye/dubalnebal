package com.strangeye.dubalnebal.service;

import com.strangeye.dubalnebal.dao.PartyUserDao;
import com.strangeye.dubalnebal.dto.Party_User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyUserServiceImpl implements PartyUserService{

	@Autowired
	PartyUserDao partyUserDao;

	@Override
	public int participateParty(Party_User partyUser) {
		return partyUserDao.participateParty(partyUser);
	}
}
