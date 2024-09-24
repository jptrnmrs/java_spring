package com.jboard.controller.comment;

import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jboard.dto.CommentDTO;
import com.jboard.service.article.CommentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/comment/modify.do")
public class ModifyController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private CommentService commentService = CommentService.INSTANCE;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		String comment = req.getParameter("comment");
		
		CommentDTO dto = new CommentDTO();
		dto.setCno(no);
		dto.setContent(comment);
	
		logger.debug("modi : "+dto);
		
		int result = commentService.updateComment(dto);

		logger.debug("result : " + result);
		JsonObject json = new JsonObject();
		json.addProperty("result", result);

		
		PrintWriter printWriter = resp.getWriter();
		printWriter.print(json);

	}
	

}
