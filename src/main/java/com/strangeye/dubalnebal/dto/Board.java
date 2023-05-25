package com.strangeye.dubalnebal.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "후기 게시판", description = "게시판 정보")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	private int board_id;
	private String board_content;
	private String board_title;
	private int board_view_cnt;
	private String board_updated_at;
	private String board_created_at;
	private int user_id;
	private String board_image;
	private String user_name;

	private String user_image;
	private String category;

	private String filename;
	private String filepath;

}

