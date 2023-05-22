package com.strangeye.dubalnebal.controller;

import com.strangeye.dubalnebal.dto.Board;
import com.strangeye.dubalnebal.dto.SerchCondition;
import com.strangeye.dubalnebal.dto.User;
import com.strangeye.dubalnebal.service.BoardService;
import com.strangeye.dubalnebal.service.UserService;
import com.strangeye.dubalnebal.util.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.locks.Condition;

@RestController
@RequestMapping("/api")
public class BoardRestController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private BoardService boardService;

	@Autowired
	private UserService userService;

	@Autowired
	JwtUtil jwtUtil;

	// 게시판 가져와
	@GetMapping("/board")
	public ResponseEntity<?> list(SerchCondition condition){
//		List<Board> list = boardService.getBoardList();
		List<Board> list = boardService.search(condition);

		if(list == null || list.size() == 0)
			return  new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return  new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}
	//상세 게시글 가져오기
	@GetMapping("/board/{board_id}")
	public ResponseEntity<?> detail(@PathVariable int board_id){
		try {
			return new ResponseEntity<Board>(boardService.detailBoard(board_id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	//게시판 등록하기
	@PostMapping("/board")
	public ResponseEntity<Board> write(@RequestBody Board board, HttpServletRequest request) throws Exception {
		System.out.println(board);
		String token = request.getHeader("HEADER_AUTH");
		Claims claims = jwtUtil.decodeToken(token);

		String claimId = "id";
		String user_identifier= claims.get(claimId, String.class);
		System.out.println(user_identifier);
		User user_found = userService.selectUserByIdentifier(user_identifier);

		System.out.println(user_found);
		board.setUser_id(user_found.getUser_id());
		boardService.writeBoard(board);
		return  new ResponseEntity<Board>(board, HttpStatus.CREATED);
	}

	//delete board
	@DeleteMapping("/board/{board_id}")
	public ResponseEntity<String> delete(@PathVariable int board_id){
		System.out.println(board_id);
		if (boardService.removeBoard(board_id)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	//modify board
	@PutMapping("/board")
	public ResponseEntity<String> update(@RequestBody Board board){
		boardService.modifyBoard(board);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}


}

