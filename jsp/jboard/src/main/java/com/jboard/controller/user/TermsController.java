package com.jboard.controller.user;

import java.io.IOException;

import com.jboard.dto.TermsDTO;
import com.jboard.service.user.TermsService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user/terms.do")
public class TermsController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private TermsService service = TermsService.INSTANCE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TermsDTO term = service.selectTerms();
		req.setAttribute("term", term);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user/terms.jsp");
		dispatcher.forward(req, resp);
	}
}

