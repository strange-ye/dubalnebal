package com.strangeye.dubalnebal.controller;

import com.strangeye.dubalnebal.dto.Board;
import com.strangeye.dubalnebal.dto.Like;
import com.strangeye.dubalnebal.dto.SerchCondition;
import com.strangeye.dubalnebal.dto.User;
import com.strangeye.dubalnebal.service.BoardService;
import com.strangeye.dubalnebal.service.LikeService;
import com.strangeye.dubalnebal.service.UserService;
import com.strangeye.dubalnebal.util.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BoardRestController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private BoardService boardService;

	@Autowired
	private LikeService likeService;

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
		System.out.println(board_id);
		try {
			System.out.println(boardService.detailBoard(board_id));
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
		System.out.println(board);
		boardService.modifyBoard(board);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}


	@GetMapping("/board/profile")
	public ResponseEntity<List<Board>> myBoard( HttpServletRequest request) throws Exception {
		String token = request.getHeader("HEADER_AUTH");
		Claims claims = jwtUtil.decodeToken(token);

		String claimId = "id";
		String user_identifier= claims.get(claimId, String.class);
//		System.out.println(user_identifier);
		User user_found = userService.selectUserByIdentifier(user_identifier);

		List<Board> list = boardService.myBoard(user_found.getUser_id());
		return  new ResponseEntity<>(list, HttpStatus.CREATED);
	}

	//게시판 좋아요 누를게
	@PostMapping("/board/like")
	public ResponseEntity<?> pushLike(@RequestBody Like like){
		System.out.println(like);

		int id = like.getBoard_board_id();
		if(likeService.hasLike(like)){
			if(likeService.removeLike(like)){
//				boardService.unlike(id);
//				Board board = boardService.detailBoard(id);
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		else{
			if(likeService.pushLike(like)){
//				boardService.dolike(id);
//				Board board = boardService.detailBoard(id);
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	//게시판 좋아요 누를게 2번 방법
//	@PostMapping("/board/like")
//	public ResponseEntity<?> pushLikeButton(@RequestParam("user_id") int user_id, @RequestParam("board_id") int board_id){
//
//		Map<String, Integer> like = new HashMap<String, Integer>();
//
//		like.put("user_id", user_id);
//		like.put("board_id", board_id);
//
//		int result = likeService.pushLike(like);
//
//		if(result == 0) {
//			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		}
//
//		return new ResponseEntity<Void>(HttpStatus.OK);
//	}


	//게시판 좋아요 취소 따로
//	@DeleteMapping("/story/dislike")
//	public ResponseEntity<?> pushDislikeButton(@RequestParam("userId") int userId, @RequestParam("storyId") int storyId){
//		Map<String, Integer> dislike = new HashMap<String, Integer>();
//
//		dislike.put("userId", userId);
//		dislike.put("storyId", storyId);
//
//		int result = sServe.dislikeStory(dislike);
//
//		if(result == 0) {
//			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		}
//
//		return new ResponseEntity<Void>(HttpStatus.OK);
//	}

}

