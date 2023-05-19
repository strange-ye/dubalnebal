package com.strangeye.dubalnebal.dao;

import java.util.List;

import com.strangeye.dubalnebal.dto.Board;
public interface BoardDao {
	//전체 게시글 가져오기
	public List<Board> selectAll();

	// ID 해당 게시글 하나 가져오기
	public Board selectOne(int id);

	// 게시글 등록
	public void insertBoard(Board board);

	// 게시글 삭제
	public void deleteBoard(int id);

	// 게시글 수정
	public void updateBoard(Board board);

	// 조회수 증가
	public void updateViewCnt(int id);


}
