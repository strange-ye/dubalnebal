package com.strangeye.dubalnebal.service;

import com.strangeye.dubalnebal.dao.BoardDao;
import com.strangeye.dubalnebal.dto.Board;
import com.strangeye.dubalnebal.dto.SerchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BoardService {


	//게시글 전체조회
	public List<Board> getBoardList();

	//게시글 상세 조회
	public Board detailBoard(int board_id);

	//게시글 등록
	public Boolean writeBoard(Board board, MultipartFile file) throws IOException;

	//게시글 삭제
	public Boolean removeBoard(int board_id);

	//게시글 수정
	public void modifyBoard(Board board);

	//view count
	public void updateViewCnt(int board_id);

	public List<Board> search(SerchCondition condition);

	public List<Board> myBoard(int user_id);

	//조하요 취소
//	public void unlike(int board_id);
//
//	public void dolike(int board_id);

}
