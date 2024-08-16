package controller.user3;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User3Service;

@WebServlet("/user3/delete.do")
public class DeleteController extends HttpServlet{

	private static final long serialVersionUID = 3989756952756485985L;
	
	private User3Service service = User3Service.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 데이터 수신
		String uid = req.getParameter("uid");
		// 데이터 삭제
		service.deleteUser3(uid);
		// 리다이렉트
		resp.sendRedirect("/ch10/user3/list.do");
	}
	
}
