package com.strangeye.dubalnebal.service;

import com.strangeye.dubalnebal.dao.BoardDao;
import com.strangeye.dubalnebal.dto.Board;
import com.strangeye.dubalnebal.dto.SerchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
	public Boolean writeBoard(Board board, MultipartFile file) throws IOException {
//		String projectPath = System.getProperty("user.dir") + "/src/main/resources/static";
		// 자기 프로젝트 경로에 맞게 설정
		String projectPath = "/Users/sangholee/Github/dubalnebal-front/public/image";
		System.out.println(projectPath);
		UUID uuid = UUID.randomUUID(); //식별자 랜덤 이름 만들어줌

		String fileName = uuid + "_" + file.getOriginalFilename();
		File saveDirectory = new File(projectPath);
		if (!saveDirectory.exists()) {
			saveDirectory.mkdirs(); // 디렉토리가 존재하지 않으면 생성합니다.
		}
		File saveFile = new File(projectPath, fileName);
		System.out.println(projectPath);
		file.transferTo(saveFile);

		board.setBoard_image(fileName);
		board.setFilepath(fileName);
    
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

	@Override
	public List<Board> myBoard(int user_id) {
		return boardDao.myProfile(user_id);
	}

//	@Override
//	public void unlike(int board_id) {
//
//	}
//
//	@Override
//	public void dolike(int board_id) {
//
//	}

	public static void main(String[] args){
		String projectPath = System.getProperty("user.dir") + "";
		System.out.println(projectPath);
	}

}
