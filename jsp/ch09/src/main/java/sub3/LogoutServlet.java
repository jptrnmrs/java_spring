package sub3;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout.do")
public class LogoutServlet extends HttpServlet{

	private static final long serialVersionUID = -3234870008998842898L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 로그아웃 처리
		HttpSession session = req.getSession();
		session.invalidate();
		
		// 메인 이동
		resp.sendRedirect("/ch09/3.Listener.jsp?success=300");
	}
}
