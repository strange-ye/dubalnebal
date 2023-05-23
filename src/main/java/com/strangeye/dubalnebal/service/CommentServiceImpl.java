package com.strangeye.dubalnebal.service;

import com.strangeye.dubalnebal.dao.CommentDao;
import com.strangeye.dubalnebal.dto.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentDao commentDao;

	@Override
	public List<Comment> getCommentList(int board_id){
		return commentDao.selectAll(board_id);
	}

	@Override
	public Boolean writeComment(Comment comment){
		return commentDao.insertComment(comment) == 1;
	}

	@Override
	public Boolean removeComment(int comment_id){
		return commentDao.deleteComment(comment_id) == 1;
	}

	@Override
	public Boolean modifyComment(Comment comment){
		return commentDao.updateComment(comment) == 1;

	}
}
