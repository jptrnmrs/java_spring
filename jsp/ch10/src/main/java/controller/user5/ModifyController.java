package controller.user5;

import java.io.IOException;

import dto.User5DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User5Service;

@WebServlet("/user5/modify.do")
public class ModifyController extends HttpServlet{

	private static final long serialVersionUID = -1116783740996152529L;
	private User5Service service = User5Service.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 데이터 수신
		String seq = req.getParameter("seq");
		
		// 데이터 조회
		User5DTO user = service.selectUser5(seq);
		
		// 데이터 공유
		req.setAttribute("user", user);
		
		// view
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user5/modify.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 데이터 수신
		String seq = req.getParameter("seq");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String addr = req.getParameter("addr");
				
		// DTO 생성 (DTO - 데이터 전송 객체, 컴포넌트 간 데이터 교환을 위한 객체)
		User5DTO dto = new User5DTO();
		dto.setSeq(seq);
		dto.setName(name);
		dto.setGender(gender);
		dto.setAge(age);
		dto.setAddr(addr);
		
		service.updateUser5(dto);
		resp.sendRedirect("/ch10/user5/list.do");
				
	}
}
