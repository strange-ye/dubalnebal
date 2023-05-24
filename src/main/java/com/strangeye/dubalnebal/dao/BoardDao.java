package com.strangeye.dubalnebal.dao;

import com.strangeye.dubalnebal.dto.Board;
import com.strangeye.dubalnebal.dto.SerchCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BoardDao {
	//전체글 조회
	List<Board> selectAll();

	// 상세글 조회
	public Board selectOne(int board_id);

	// 게시글 등록
	public int insertBoard(Board board);

	// 게시글 삭제
	public int deleteBoard(int board_id);

	// 게시글 수정
	public int updateBoard(Board board);

	// 조회수 증가
	public void updateViewCnt(int board_id);

	//검색기능
	public List<Board> search(SerchCondition condition);

	//저장될 파일 이름
	public String filename(int board_id);

	//파일 경로
//	public String filepath(int board_id);

	//사용자가 올릴 파일 이름원본
	public String Board_image(Board board);

	public List<Board> myProfile(int user_id);

}
