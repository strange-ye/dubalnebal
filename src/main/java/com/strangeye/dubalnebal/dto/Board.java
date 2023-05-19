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
//
//	public Board() {
//	}
//
//	public Board(int board_id, String board_content, String board_title, int board_view_cnt, String board_updated_at, String board_created_at, int user_id, String board_image, String user_name) {
//		this.board_id = board_id;
//		this.board_content = board_content;
//		this.board_title = board_title;
//		this.board_view_cnt = board_view_cnt;
//		this.board_updated_at = board_updated_at;
//		this.board_created_at = board_created_at;
//		this.user_id = user_id;
//		this.board_image = board_image;
//		this.user_name = user_name;
//	}
//
//	public int getBoard_id() {
//		return board_id;
//	}
//
//	public void setBoard_id(int board_id) {
//		this.board_id = board_id;
//	}
//
//	public String getBoard_content() {
//		return board_content;
//	}
//
//	public void setBoard_content(String board_content) {
//		this.board_content = board_content;
//	}
//
//	public String getBoard_title() {
//		return board_title;
//	}
//
//	public void setBoard_title(String board_title) {
//		this.board_title = board_title;
//	}
//
//	public int getBoard_view_cnt() {
//		return board_view_cnt;
//	}
//
//	public void setBoard_view_cnt(int board_view_cnt) {
//		this.board_view_cnt = board_view_cnt;
//	}
//
//	public String getBoard_updated_at() {
//		return board_updated_at;
//	}
//
//	public void setBoard_updated_at(String board_updated_at) {
//		this.board_updated_at = board_updated_at;
//	}
//
//	public String getBoard_created_at() {
//		return board_created_at;
//	}
//
//	public void setBoard_created_at(String board_created_at) {
//		this.board_created_at = board_created_at;
//	}
//
//	public int getUser_id() {
//		return user_id;
//	}
//
//	public void setUser_id(int user_id) {
//		this.user_id = user_id;
//	}
//
//	public String getBoard_image() {
//		return board_image;
//	}
//
//	public void setBoard_image(String board_image) {
//		this.board_image = board_image;
//	}
//
//	public String getUser_name() {
//		return user_name;
//	}
//
//	public void setUser_name(String user_name) {
//		this.user_name = user_name;
//	}
//
//	@Override
//	public String toString() {
//		return "Board{" +
//				"board_id=" + board_id +
//				", board_content='" + board_content + '\'' +
//				", board_title='" + board_title + '\'' +
//				", board_view_cnt=" + board_view_cnt +
//				", board_updated_at='" + board_updated_at + '\'' +
//				", board_created_at='" + board_created_at + '\'' +
//				", user_id=" + user_id +
//				", board_image='" + board_image + '\'' +
//				", user_name='" + user_name + '\'' +
//				'}';
//	}
}

