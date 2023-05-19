package com.strangeye.dubalnebal.controller;

import com.strangeye.dubalnebal.dto.Board;
import com.strangeye.dubalnebal.service.BoardService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@Api(tags = "게시판 컨트롤러")
public class BoardRestController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private BoardService boardService;

	@GetMapping("/board")
	public ResponseEntity<?> list(){
		return new ResponseEntity<>("hi", HttpStatus.OK);
	}

//	@PostMapping("/upload")
//	public ResponseEntity<?> upload(@RequestParam Board board) {
//		BoardService.insert(board)
//		return new ResponseEntity<>()
//	}

}
