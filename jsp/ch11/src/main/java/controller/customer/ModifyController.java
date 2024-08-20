package controller.customer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.CustomerDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CustomerService;

@WebServlet("/customer/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service = CustomerService.INSTANCE;

	// 로거 생성
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String custId	= req.getParameter("custId");
		CustomerDTO customer = service.selectCustomer(custId);
		logger.info("customer - "+customer);
		
		req.setAttribute("customer", customer);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/customer/modify.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String custId	= req.getParameter("custId");
		String name		= req.getParameter("name");
		String hp		= req.getParameter("hp");
		String addr		= req.getParameter("addr");
		String rdate	= req.getParameter("rdate");
		
		logger.debug("custId : "+custId);
		logger.debug("name : "+name);
		logger.debug("rdate : "+rdate);
		
		CustomerDTO dto = new CustomerDTO();
		dto.setCustId(custId);
		dto.setName(name);
		dto.setHp(hp);
		dto.setAddr(addr);
		dto.setRdate(rdate);
		
		logger.info(dto.toString());
		
		service.updateCustomer(dto);
		
		resp.sendRedirect("/ch11/customer/list.do");
	
	}
}
