package com.jboard.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jboard.dto.ArticleDTO;
import com.jboard.util.DBHelper;
import com.jboard.util.SQL;

public class ArticleDAO extends DBHelper{
	private static ArticleDAO instance = new ArticleDAO();
	public static ArticleDAO getInstance() {
		return instance;
	}
	private ArticleDAO() {}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void veiwArticle(int no) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.VIEW_ARTICLE);
			psmt.setInt(1, no);
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	public int insertArticle(ArticleDTO article) {
		int no = 0;
		try {
			conn = getConnection();
			
			conn.setAutoCommit(false);
			
			psmt = conn.prepareStatement(SQL.INSERT_ARTICLE);
			psmt.setString(1, article.getTitle());
			psmt.setString(2, article.getContent());
			psmt.setInt(3, article.getFile());
			psmt.setString(4, article.getWriter());
			psmt.setString(5, article.getRegip());
			psmt.executeUpdate();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_MAX_NO);
			if(rs.next()) no = rs.getInt(1);
			
			conn.commit();
			
			closeAll();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return no;
	}
	public ArticleDTO selectArticle(int no) {
		ArticleDTO article = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ARTICLE);
			psmt.setInt(1, no);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				article = new ArticleDTO();
				article.setNo(rs.getInt(1));
				article.setCate(rs.getString(2));
				article.setTitle(rs.getString(3));
				article.setContent(rs.getString(4));
				article.setComment(rs.getInt(5));
				article.setFile(rs.getInt(6));
				article.setHit(rs.getInt(7));
				article.setWriter(rs.getString(8));
				article.setRegip(rs.getString(9));
				article.setRdate(rs.getString(10));
			}
			
			closeAll();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return article;
	}
	public List<ArticleDTO> selectArticles() {	
		List<ArticleDTO> articles = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ARTICLES);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ArticleDTO dto = new ArticleDTO();
				dto.setNo(rs.getInt(1));
				dto.setCate(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setComment(rs.getInt(5));
				dto.setFile(rs.getInt(6));
				dto.setHit(rs.getInt(7));
				dto.setWriter(rs.getString(8));
				dto.setRegip(rs.getString(9));
				dto.setRdate(rs.getString(10));
				dto.setWriterNick(rs.getString(11));
				articles.add(dto);
			}
			
			closeAll();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return articles;
	}
	public void updateArticle(ArticleDTO article) {	}
	public void deleteArticle(ArticleDTO article) {	}
}
