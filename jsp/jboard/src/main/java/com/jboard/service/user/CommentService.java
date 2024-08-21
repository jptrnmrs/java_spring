package com.jboard.service.user;

import java.util.List;

import com.jboard.dao.CommentDAO;
import com.jboard.dto.CommentDTO;

public enum CommentService {
	INSTANCE;
	
	private CommentDAO dao = CommentDAO.getInstance();
	
	public List<CommentDTO> selectArticleComments(int parent) {
		return dao.selectArticleComments(parent);
	}
}
