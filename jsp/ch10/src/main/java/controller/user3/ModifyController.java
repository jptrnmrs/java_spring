package controller.user3;

import java.io.IOException;

import dto.User3DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User3Service;

@WebServlet("/user3/modify.do")
public class ModifyController extends HttpServlet{

	private static final long serialVersionUID = 3989756952756485985L;
	private User3Service service = User3Service.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 데이터 수신
		String uid = req.getParameter("uid");
		
		// 데이터 조회
		User3DTO user = service.selectUser3(uid);
		
		// 데이터 공유
		req.setAttribute("user", user);
		
		// view
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user3/modify.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 데이터 수신
		String uid = req.getParameter("uid");
		String name = req.getParameter("name");
		String birth = req.getParameter("birth");
		String hp = req.getParameter("hp");
		String addr = req.getParameter("addr");
				
		// DTO 생성 (DTO - 데이터 전송 객체, 컴포넌트 간 데이터 교환을 위한 객체)
		User3DTO dto = new User3DTO();
		dto.setUid(uid);
		dto.setName(name);
		dto.setBirth(birth);
		dto.setHp(hp);
		dto.setAddr(addr);
		
		service.updateUser3(dto);
		resp.sendRedirect("/ch10/user3/list.do");
				
	}
}
