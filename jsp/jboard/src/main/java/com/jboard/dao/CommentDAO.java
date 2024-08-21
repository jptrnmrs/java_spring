package com.jboard.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jboard.dto.CommentDTO;
import com.jboard.util.DBHelper;
import com.jboard.util.SQL;

public class CommentDAO extends DBHelper{
	private static CommentDAO instance = new CommentDAO();
	public static CommentDAO getInstance() {
		return instance;
	}
	private CommentDAO() {}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public void insertComment() {
		
	}
	public void selectComment() {
		
	}
	public List<CommentDTO> selectArticleComments(int parent) {
		List<CommentDTO> comments = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COMMENTS);
			psmt.setInt(1, parent);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CommentDTO comment = new CommentDTO();
				comment.setNo(rs.getInt(1));
				comment.setParent(rs.getInt(2));
				comment.setContent(rs.getString(3));
				comment.setWriter(rs.getString(4));
				comment.setRegip(rs.getString(5));
				comment.setRdate(rs.getString(6));
				comments.add(comment);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return comments;
		
	}
	public void updateComment() {
		
	}
	public void deleteComment() {
		
	}
}
