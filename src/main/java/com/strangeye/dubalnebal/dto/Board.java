package com.strangeye.dubalnebal.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "후기 게시판", description = "게시판 정보")
public class Board {
	private int id;
	private String title;
	private String content;
	private int viewCnt;
}
