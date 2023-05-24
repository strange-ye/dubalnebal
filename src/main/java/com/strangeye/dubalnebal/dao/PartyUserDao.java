package com.strangeye.dubalnebal.dao;

import com.strangeye.dubalnebal.dto.Party_User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PartyUserDao {

	// 파티 참여
	int participateParty(Party_User partyUser);

}
