package com.jboard.controller.user;

import java.io.IOException;

import com.jboard.dto.UserDTO;
import com.jboard.service.user.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user/login.do")
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private UserService service = UserService.INSTANCE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user/login.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		String pass = req.getParameter("pass");
		UserDTO user = service.selectUser(uid);
		Boolean correct = pass.equals(user.getPass());
		if(correct) {
			req.setAttribute("user", user);
			resp.sendRedirect("/jboard/article/list.do");
		}
	}
}

