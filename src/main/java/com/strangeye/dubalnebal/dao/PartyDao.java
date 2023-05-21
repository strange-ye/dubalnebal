package com.strangeye.dubalnebal.dao;

import com.strangeye.dubalnebal.dto.Party;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PartyDao {

	// 파티 생성
	int writeParty(Party party);

	// id로 파티 정보 가져오기
	Party selectParty(int party_id);

	// 파티 업데이트
	int updateParty(Party party);

	// id로 파티 삭제
	int deleteParty(int party_id);
}
