package com.strangeye.dubalnebal.dao;

import com.strangeye.dubalnebal.dto.Like;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeDao {

	public int insertLike(Like like);

	public int disLike(Like like);

	public int selectLikeCnt(Like like);


}
