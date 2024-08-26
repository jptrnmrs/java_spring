package com.jboard.dao;

import java.sql.Statement;
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
	
	
	public void countComments(String no) {
		int count = 0;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);

			psmt = conn.prepareStatement(SQL.COUNT_COMMENTS);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
			psmt = conn.prepareStatement(SQL.UPDATE_COUNT);
			psmt.setInt(1, count);
			psmt.setString(2, no);
			psmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			closeAll();
		}
	}
	
	public int insertComment(CommentDTO comment) {
		int pk = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_COMMENT, Statement.RETURN_GENERATED_KEYS); // INSERT 실행 후 자동 생성되는 PK값을 반환하는 쿼리
			psmt.setInt(1, comment.getParent());
			psmt.setString(2, comment.getContent());
			psmt.setString(3, comment.getWriter());
			psmt.setString(4, comment.getRegip());
			psmt.executeUpdate();
			rs = psmt.getGeneratedKeys();
			if(rs.next()) {
				pk = rs.getInt(1);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			closeAll();
		}
		return pk;
	}
	public CommentDTO selectComment(int no) {
		CommentDTO comment = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COMMENT);
			psmt.setInt(1, no);
			rs = psmt.executeQuery();
			if(rs.next()) {
				comment = new CommentDTO();
				comment.setNo(rs.getInt(1));
				comment.setParent(rs.getInt(2));
				comment.setContent(rs.getString(3));
				comment.setWriter(rs.getString(4));
				comment.setRegip(rs.getString(5));
				comment.setRdateSubstring(rs.getString(6));
				comment.setNick(rs.getString(7));
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			closeAll();
		}
		return comment;
	}
	public List<CommentDTO> selectComments(String parent) {
		List<CommentDTO> comments = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COMMENTS);
			psmt.setString(1, parent);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CommentDTO comment = new CommentDTO();
				comment.setNo(rs.getInt(1));
				comment.setParent(rs.getInt(2));
				comment.setContent(rs.getString(3));
				comment.setWriter(rs.getString(4));
				comment.setRegip(rs.getString(5));
				comment.setRdateSubstring(rs.getString(6));
				comment.setNick(rs.getString(7));
				comments.add(comment);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			closeAll();
		}
		return comments;
		
	}
	public int updateComment(CommentDTO comment) {
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_COMMENT);
			psmt.setString(1, comment.getContent());
			psmt.setInt(2, comment.getNo());
			result = psmt.executeUpdate();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			closeAll();
		}
		return result;
	}
	public int deleteComment(String no) {
		int result = 0;
		try {
			conn = getConnection();
			
			psmt = conn.prepareStatement(SQL.DELETE_COMMENT);
			psmt.setString(1, no);
			result = psmt.executeUpdate();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			closeAll();
		}
		return result;
	}
}
