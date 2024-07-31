package shop.dao;

import java.util.List;

import shop.vo.CustomerVO;
import shop.db.*;

public class CustomerDAO extends DBHelper {

	private static CustomerDAO instance = new CustomerDAO();
	public static CustomerDAO getInstance() {
		return instance;
	}
	private CustomerDAO() {}

	public int insertCustomer(CustomerVO vo) {
		int count=0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_CUSTOMER);
			psmt.setString(1,vo.getCustId());
			psmt.setString(2,vo.getName());
			psmt.setString(3,vo.getHp());
			psmt.setString(4,vo.getAddr());
			count = psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
	public CustomerVO searchCustomer(String custId) {
		CustomerVO vo = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_CUSTOMER);
			psmt.setString(1,custId);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo=new CustomerVO();
				vo.setCustId(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setHp(rs.getString(3));
				vo.setAddr(rs.getString(4));
				vo.setRdate(rs.getString(5));
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	public List<CustomerVO> selectCustomers() {
		List<CustomerVO> users = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public int updateCustomer(CustomerVO vo) {
		int count=0;
		return count;
	}
	public int deleteCustomer(String custId) {
		int count=0;
		return count;
	}
}
