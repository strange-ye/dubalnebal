package com.strangeye.dubalnebal.dao;

import com.strangeye.dubalnebal.dto.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentDao {
	//코멘트 전체
	public List<Comment> selectAll(int board_id);

	public int insertComment(Comment comment);

	public int deleteComment(int comment_id);

	public int updateComment(Comment comment);

}
