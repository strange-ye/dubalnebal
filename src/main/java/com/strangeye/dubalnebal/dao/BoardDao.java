package com.strangeye.dubalnebal.dao;

import com.strangeye.dubalnebal.dto.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BoardDao {
	//전체글 조회
	List<Board> selectAll();

	// 상세글 조회
	public Board selectOne(int board_id);

	// 게시글 등록
	public void insertBoard(Board board);

	// 게시글 삭제
	public void deleteBoard(int board_id);

	// 게시글 수정
	public void updateBoard(Board board);

	// 조회수 증가
	public void updateViewCnt(int board_id);


}
