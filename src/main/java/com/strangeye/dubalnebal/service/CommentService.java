package com.strangeye.dubalnebal.service;

import com.strangeye.dubalnebal.dto.Comment;

import java.util.List;

public interface CommentService {

	public List<Comment> getCommentList(int board_id);

	public Boolean writeComment(Comment comment, int user_identifier);

	public Boolean removeComment(int comment_id);

	public Boolean modifyComment(Comment comment);



}
