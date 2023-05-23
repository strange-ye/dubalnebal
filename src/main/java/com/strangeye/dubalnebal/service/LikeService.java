package com.strangeye.dubalnebal.service;

import com.strangeye.dubalnebal.dto.Like;

public interface LikeService {
	public boolean pushLike(Like like);

	public boolean removeLike(Like like);

	public boolean hasLike(Like like);

}
