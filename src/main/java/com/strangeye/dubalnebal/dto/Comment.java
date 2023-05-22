package com.strangeye.dubalnebal.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
	private int comment_id;
	private String comment_content;
	private String comment_created_at;
	private String comment_updated_at;
	private int board_id;
	private int user_id;
	private String user_name;
	private String user_image;

}
