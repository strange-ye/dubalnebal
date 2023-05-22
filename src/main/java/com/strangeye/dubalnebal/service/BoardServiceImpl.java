package com.strangeye.dubalnebal.service;

import com.strangeye.dubalnebal.dao.BoardDao;
import com.strangeye.dubalnebal.dto.Board;
import com.strangeye.dubalnebal.dto.SerchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

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

	public Boolean writeBoard(Board board) {
    
//		String projectPath = System.getProperty("user.dir") + "/src/main/resources/static.files";
//
//		UUID uuid = UUID.randomUUID(); //식별자 랜덤 이름 만들어줌
//
//		String fileName = uuid + "_" + file.getOriginalFilename();
//
//		File saveFile = new File(projectPath, fileName);
//
//		file.transferTo(saveFile);
//
//		board.setBoard_image();
//		board.setFilepath();
    
		 return boardDao.insertBoard(board) == 1;
    
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

	@Override
	public List<Board> search(SerchCondition condition){
		return boardDao.search(condition);
	}


	public static void main(String[] args){
		String projectPath = System.getProperty("user.dir") + "";
		System.out.println(projectPath);
	}

}
