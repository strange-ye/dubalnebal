package com.strangeye.dubalnebal.service;

import com.strangeye.dubalnebal.dao.BoardDao;
import com.strangeye.dubalnebal.dto.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;

//	@Autowired
//	public void setBoardDao(BoardDao boardDao){
//		this.boardDao = boardDao;
//	}

	@Override
	public List<Board> getBoardList(){
		return  boardDao.selectAll();
	}

	@Override
	public Board detailBoard(int board_id) {
		return null;
	}

	@Override
	public void writeBoard(Board board) {

	}

	@Override
	public void removeBoard(int board_id) {

	}

	@Override
	public void modifyBoard(Board board) {

	}

	@Override
	public void updateViewCnt(int board_id) {

	}


}
