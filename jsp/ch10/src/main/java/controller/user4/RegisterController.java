package controller.user4;

import java.io.IOException;

import dto.User4DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User4Service;

@WebServlet("/user4/register.do")
public class RegisterController extends HttpServlet{

	private static final long serialVersionUID = 3989756952756485985L;
	
	private User4Service service = User4Service.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user4/register.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 데이터 수신
		String uid = req.getParameter("uid");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String hp = req.getParameter("hp");
		String addr = req.getParameter("addr");
			
		// DTO 생성 (DTO - 데이터 전송 객체, 컴포넌트 간 데이터 교환을 위한 객체)
		User4DTO dto = new User4DTO();
		dto.setUid(uid);
		dto.setName(name);
		dto.setGender(gender);
		dto.setAge(age);
		dto.setHp(hp);
		dto.setAddr(addr);
		
		// 모델 서비스 호출
		service.insertUser4(dto);
		
		// 리다이렉트
		resp.sendRedirect("/ch10/user4/list.do");
	}
	
}
