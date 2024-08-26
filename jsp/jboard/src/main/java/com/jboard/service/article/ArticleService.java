package com.jboard.service.article;

import java.util.List;

import com.jboard.dao.ArticleDAO;
import com.jboard.dto.ArticleDTO;
import com.jboard.dto.PageGroupDTO;

public enum ArticleService {
	INSTANCE;
	private ArticleDAO dao = ArticleDAO.getInstance();
	
	
	
	public void veiwArticle(String num) {
		int no = Integer.parseInt(num);
		dao.veiwArticle(no);
	}
	
	public int getLastPageNum(int total) {
		int lastPageNum = 0;
		if(total%10==0) {
			lastPageNum = total/10;
		}else {
			lastPageNum = total/10 + 1;
		}
		return lastPageNum;
	}
	public int getStartNum(int currentPage) {
		return (currentPage-1)*10;
	}
	
	public int getCurrentPage(String pg) {
		int currentPage = 1;
		
		if(pg != null) {
			currentPage = Integer.parseInt(pg);
		}
		return currentPage;
	}
	public PageGroupDTO getCurrentPageGroup(int currentPage) {
		int currentPageGroup = (int)Math.ceil(currentPage/10.0);
		int pageGroupStart = (currentPageGroup-1)*10 +1;
		int pageGroupEnd = currentPageGroup*10;
		return new PageGroupDTO(pageGroupStart, pageGroupEnd);
	}
	public int  insertArticle(ArticleDTO article) {
		return dao.insertArticle(article);
	}
	public int selectCountTotal() {
		return dao.selectCountTotal();
	}
	public ArticleDTO selectArticle(String num) {
		int no = Integer.parseInt(num);
		return dao.selectArticle(no);
	}
	public ArticleDTO selectArticle(int no) {
		return dao.selectArticle(no);
	}
	public List<ArticleDTO> selectArticles(int start) {
		return dao.selectArticles(start);
	}
	public void updateArticle(ArticleDTO article) {	
		dao.updateArticle(article);
	}
	public void deleteArticle(ArticleDTO article) {
		dao.deleteArticle(article);
	}
}
