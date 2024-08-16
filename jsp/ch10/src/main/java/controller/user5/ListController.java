package controller.user5;

import java.io.IOException;
import java.util.List;

import dto.User5DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User5Service;

@WebServlet("/user5/list.do")
public class ListController extends HttpServlet{

	private static final long serialVersionUID = 2135931920365600332L;
	private User5Service service = User5Service.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 데이터 조회하기
		List<User5DTO> users = service.selectUser5s();
		
		// 데이터 공유 (view에서 데이터를 출력하기 위해 같은 request scope 사용
		req.setAttribute("users", users);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user5/list.jsp");
		dispatcher.forward(req, resp);
	}
}
