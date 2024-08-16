package controller.user5;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User5Service;

@WebServlet("/user5/delete.do")
public class DeleteController extends HttpServlet{

	private static final long serialVersionUID = -3230451341751254121L;

	
	private User5Service service = User5Service.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 데이터 수신
		String seq = req.getParameter("seq");
		// 데이터 삭제
		service.deleteUser5(seq);
		// 리다이렉트
		resp.sendRedirect("/ch10/user5/list.do");
	}
	
}
