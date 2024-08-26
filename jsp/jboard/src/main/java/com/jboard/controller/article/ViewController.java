package com.jboard.controller.article;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jboard.dto.ArticleDTO;
import com.jboard.dto.CommentDTO;
import com.jboard.service.article.ArticleService;
import com.jboard.service.article.CommentService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/article/view.do")
public class ViewController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private ArticleService articleService = ArticleService.INSTANCE;
	private CommentService commentService = CommentService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		
		articleService.veiwArticle(no); // 조회수 증가
		
		// 게시글 조회
		ArticleDTO article = articleService.selectArticle(no);
		
		// 댓글 조회
		List<CommentDTO> comments = commentService.selectComments(no);
		
		// 공유 참조
		req.setAttribute("article", article);
		req.setAttribute("comments", comments);
		
		logger.debug(article.toString());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/article/view.jsp");
		dispatcher.forward(req, resp);
	}
}
