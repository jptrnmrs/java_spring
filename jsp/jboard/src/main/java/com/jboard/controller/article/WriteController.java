package com.jboard.controller.article;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jboard.dto.ArticleDTO;
import com.jboard.dto.FileDTO;
import com.jboard.dto.UserDTO;
import com.jboard.service.article.ArticleService;
import com.jboard.service.article.FileService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/article/write.do")
public class WriteController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private ArticleService articleService = ArticleService.INSTANCE;
	private FileService fileService = FileService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/article/write.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		String regip = req.getRemoteAddr();
		
		// 파일 업로드
		List<FileDTO> files = fileService.fileUpload(req);
		
		// 글 등록
		ArticleDTO article = new ArticleDTO();
		article.setTitle(title);
		article.setContent(content);
		article.setFile(files.size());
		article.setWriter(writer);
		article.setRegip(regip);
		logger.debug(article.toString());
		
		// 글 번호 불러오기
		int no = articleService.insertArticle(article);

		// 파일 등록
		for(FileDTO file : files) {
			file.setAno(no);
			fileService.insertFile(file);
		}
		
		resp.sendRedirect("/jboard/article/list.do");
	}
}
