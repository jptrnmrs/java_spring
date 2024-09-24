package com.jboard.controller.comment;

import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.jboard.dto.CommentDTO;
import com.jboard.service.article.CommentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/comment/write.do")
public class WriteController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private CommentService commentService = CommentService.INSTANCE;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ano = req.getParameter("ano");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		String regip = req.getLocalAddr();
		
		CommentDTO dto = new CommentDTO();
		dto.setAno(ano);
		dto.setContent(content);
		dto.setWriter(writer);
		dto.setRegip(regip);
		
		// 댓글 등록
		int pk = commentService.insertComment(dto);
		commentService.countComments(ano);
		
		// 방금 등록한 댓글 조회
		CommentDTO comment = commentService.selectComment(pk);
		logger.debug(comment.toString());
		
		Gson gson = new Gson();
		String json = gson.toJson(comment);

		PrintWriter printWriter = resp.getWriter();
		printWriter.print(json);
		
//		resp.sendRedirect("/jboard/article/view.do?no="+parent);
		
	}

}
