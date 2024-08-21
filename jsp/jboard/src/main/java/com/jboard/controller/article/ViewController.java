package com.jboard.controller.article;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jboard.dto.ArticleDTO;
import com.jboard.dto.CommentDTO;
import com.jboard.dto.FileDTO;
import com.jboard.service.user.ArticleService;
import com.jboard.service.user.CommentService;
import com.jboard.service.user.FileService;

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
	private FileService fileService = FileService.INSTANCE;
	private CommentService commentService = CommentService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		
		articleService.veiwArticle(no); // 조회수 증가
		
		ArticleDTO article = articleService.selectArticle(no);
		req.setAttribute("article", article);
		List<FileDTO> files = fileService.selectArticleFile(article.getNo());
		int i = 1;
		for(FileDTO file : files) {
			req.setAttribute("file"+i++, file);
		}
		List<CommentDTO> comments = commentService.selectArticleComments(article.getNo());
		req.setAttribute("comments", comments);
		logger.debug(article.toString());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/article/view.jsp");
		dispatcher.forward(req, resp);
	}
}
