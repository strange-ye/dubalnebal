package com.strangeye.dubalnebal.service;

import com.strangeye.dubalnebal.dao.BoardDao;
import com.strangeye.dubalnebal.dto.Board;
import com.strangeye.dubalnebal.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardDao boardDao;



	@Override
	public List<Board> getBoardList(){
		return  boardDao.selectAll();
	}

	@Override
	public Board detailBoard(int board_id) {
		boardDao.updateViewCnt(board_id);
		return boardDao.selectOne(board_id);
	}

	@Override
	public Boolean writeBoard(Board board , int user_id) {
		 return boardDao.insertBoard(board, user_id) == 1;
	}

	@Override
	public Boolean removeBoard(int board_id) {
		return boardDao.deleteBoard(board_id) == 1;
	}

	@Override
	public void modifyBoard(Board board) {
		Board originBoard = boardDao.selectOne(board.getBoard_id());
		originBoard.setBoard_title(board.getBoard_title());
		originBoard.setBoard_content(board.getBoard_content());
		boardDao.updateBoard(originBoard);
	}

	@Override
	public void updateViewCnt(int board_id) {
		Board board = boardDao.selectOne(board_id);
		board.setBoard_view_cnt(board.getBoard_view_cnt()+1);
		boardDao.updateBoard(board);
	}


}
