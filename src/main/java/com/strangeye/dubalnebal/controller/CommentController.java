package com.strangeye.dubalnebal.controller;

import com.strangeye.dubalnebal.dto.Comment;
import com.strangeye.dubalnebal.dto.User;
import com.strangeye.dubalnebal.service.CommentService;
import com.strangeye.dubalnebal.service.UserService;
import com.strangeye.dubalnebal.util.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@Autowired
	private UserService userService;

	@Autowired
	JwtUtil jwtUtil;

	//댓글 가져와
	@GetMapping("/comment/{board_id}")
	public ResponseEntity<?> list(@PathVariable int board_id) {
		List<Comment> list = commentService.getCommentList(board_id);
		for (Comment comment : list) {
			System.out.println(comment);
		}
		if (list == null || list.size() == 0) return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Comment>>(list, HttpStatus.OK);
	}

	//	게시판 등록하기
	@PostMapping("/comment")
	public ResponseEntity<?> write(@RequestBody Comment comment, HttpServletRequest request) throws UnsupportedEncodingException {
		String token = request.getHeader("HEADER_AUTH");
		Claims claims = jwtUtil.decodeToken(token);

		String claimId = "id";
		String user_identifier= claims.get(claimId, String.class);
		User user_found = userService.selectUserByIdentifier(user_identifier);

		commentService.writeComment(comment, user_found.getUser_id());
		return new ResponseEntity<>(comment, HttpStatus.CREATED);
	}

	@DeleteMapping("/comment/{comment_id}")
	public ResponseEntity<Void> delete(@PathVariable int comment_id) {
		commentService.removeComment(comment_id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping("/comment")
	public ResponseEntity<Void> update(@RequestBody Comment comment) {
		commentService.modifyComment(comment);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}


}
