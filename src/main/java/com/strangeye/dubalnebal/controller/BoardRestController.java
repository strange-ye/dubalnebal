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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

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
		System.out.println(condition);
		List<Board> list = boardService.search(condition);

		if(list == null || list.size() == 0)
			return  new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return  new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}

	@GetMapping("/board/all")
	public ResponseEntity<?> listAll(){
//		List<Board> list = boardService.getBoardList();
		List<Board> list = boardService.getBoardList();

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	//상세 게시글 가져오기
	@GetMapping("/board/{board_id}")
	public ResponseEntity<?> detail(@PathVariable int board_id){
		try {
			System.out.println(boardService.detailBoard(board_id));
			return new ResponseEntity<Board>(boardService.detailBoard(board_id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	//게시판 등록하기
	@PostMapping("/board")
	public ResponseEntity<Board> write(Board board, @RequestParam MultipartFile file, HttpServletRequest request) throws Exception {
		System.out.println(board);
		String token = request.getHeader("HEADER_AUTH");
		Claims claims = jwtUtil.decodeToken(token);

		String claimId = "id";
		String user_identifier= claims.get(claimId, String.class);
		System.out.println(user_identifier);
		User user_found = userService.selectUserByIdentifier(user_identifier);

		System.out.println(user_found);
		board.setUser_id(user_found.getUser_id());
		boardService.writeBoard(board, file);
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
	public ResponseEntity<List<Board>> myBoard(HttpServletRequest request) throws Exception {
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
	public ResponseEntity<?> pushLike(Like like, HttpServletRequest request) throws UnsupportedEncodingException {
		String token = request.getHeader("HEADER_AUTH");
		Claims claims = jwtUtil.decodeToken(token);

		String claimId = "id";
		String user_identifier= claims.get(claimId, String.class);
//		System.out.println(user_identifier);
		User user_found = userService.selectUserByIdentifier(user_identifier);

		int id = like.getBoard_board_id();
		like.setUser_user_id(user_found.getUser_id());
		System.out.println(like);
		if (likeService.hasLike(like)){
			if (likeService.removeLike(like)){
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

	// 좋아요 눌렀는지 체크
	@GetMapping("/board/like/{board_id}")
	public ResponseEntity<?> getLike(@PathVariable int board_id, HttpServletRequest request) throws UnsupportedEncodingException {
		System.out.println(board_id);

		String token = request.getHeader("HEADER_AUTH");
		Claims claims = jwtUtil.decodeToken(token);

		String claimId = "id";
		String user_identifier= claims.get(claimId, String.class);
//		System.out.println(user_identifier);
		if (user_identifier == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		User user_found = userService.selectUserByIdentifier(user_identifier);
		Like like = new Like(user_found.getUser_id(), board_id);
		boolean result = likeService.hasLike(like);

		System.out.println(result);
		if (result) {
			System.out.println("no heart");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		System.out.println("yes heart");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/board/upload")
	public ResponseEntity<Integer> uploadimg(@RequestParam("uploadFile")MultipartFile multipartFile){
		String uploadFilePath = multipartFile.getOriginalFilename();

		File folder = new File(uploadFilePath);
		if(!folder.exists())
			folder.mkdir();

		String filename = multipartFile.getOriginalFilename();
		File target = new File(uploadFilePath, filename);

		return new ResponseEntity<Integer>(HttpStatus.OK);

	}


}

