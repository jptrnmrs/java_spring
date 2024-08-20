package service;

import java.util.List;

import dao.CustomerDAO;
import dto.CustomerDTO;

public enum CustomerService {
	
	INSTANCE;
	private CustomerDAO dao = CustomerDAO.getInstance();
	
	public void insertCustomer(CustomerDTO dto) {
		dao.insertCustomer(dto);
	}
	public CustomerDTO selectCustomer(String custId) {
		return dao.selectCustomer(custId);
	}
	public List<CustomerDTO> selectCustomers() {
		return dao.selectCustomers();
	}
	public void updateCustomer(CustomerDTO dto) {
		dao.updateCustomer(dto);
	}
	public void deleteCustomer(String custId) {
		dao.deleteCustomer(custId);
	}
}
