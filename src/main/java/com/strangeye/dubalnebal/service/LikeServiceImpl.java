package com.strangeye.dubalnebal.service;

import com.strangeye.dubalnebal.dao.LikeDao;
import com.strangeye.dubalnebal.dto.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	LikeDao likeDao;

	@Override
	public boolean pushLike(Like like) {
		return likeDao.insertLike(like) == 1;
	}

	@Override
	public boolean removeLike(Like like) {
		return likeDao.disLike(like) == 1;
	}

	@Override
	public boolean hasLike(Like like) {
		return likeDao.selectLikeCnt(like) != 0;
	}
}
