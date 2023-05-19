package com.strangeye.dubalnebal.controller;

import com.strangeye.dubalnebal.service.BoardService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Api(tags = "게시판 컨트롤러")
public class BoardRestController {

	@Autowired
	private BoardService boardService;


}
