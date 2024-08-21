package com.jboard.service.user;

import java.util.List;

import com.jboard.dao.ArticleDAO;
import com.jboard.dto.ArticleDTO;

public enum ArticleService {
	INSTANCE;
	private ArticleDAO dao = ArticleDAO.getInstance();
	
	public void veiwArticle(String num) {
		int no = Integer.parseInt(num);
		dao.veiwArticle(no);
	}
	public int  insertArticle(ArticleDTO article) {
		return dao.insertArticle(article);
	}
	public ArticleDTO selectArticle(String num) {
		int no = Integer.parseInt(num);
		return dao.selectArticle(no);
	}
	public ArticleDTO selectArticle(int no) {
		return dao.selectArticle(no);
	}
	public List<ArticleDTO> selectArticles() {
		return dao.selectArticles();
	}
	public void updateArticle(ArticleDTO article) {	
		dao.updateArticle(article);
	}
	public void deleteArticle(ArticleDTO article) {
		dao.deleteArticle(article);
	}
}
