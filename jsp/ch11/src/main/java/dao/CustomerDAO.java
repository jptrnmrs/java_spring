package dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.CustomerDTO;
import util.DBHelper;

public class CustomerDAO extends DBHelper{
	private static CustomerDAO instance = new CustomerDAO();
	public static CustomerDAO getInstance() {
		return instance;
	}

	// 로거 생성
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertCustomer(CustomerDTO dto) {
		String sql = "insert into `Customer` values (?,?,?,?,?)";
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getCustId());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getHp());
			psmt.setString(4, dto.getAddr());
			psmt.setString(5, dto.getRdate());
			psmt.executeUpdate();
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public CustomerDTO selectCustomer(String custId) {
		CustomerDTO dto = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("select * from `Customer` where `custId`=?");
			psmt.setString(1, custId);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new CustomerDTO();
				dto.setCustId(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAddr(rs.getString(4));
				dto.setRdate(rs.getString(5));
			}
			
			closeAll();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return dto;
	}
	public List<CustomerDTO> selectCustomers() {
		List<CustomerDTO> customers = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from `Customer`");
			
			while(rs.next()) {
				CustomerDTO dto = new CustomerDTO();
				dto.setCustId(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAddr(rs.getString(4));
				dto.setRdate(rs.getString(5));
				customers.add(dto);
			}
			
			closeAll();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return customers;
	}
	
	public void updateCustomer(CustomerDTO dto) {
		String sql = "update `Customer` set `name`=?,`hp`=?,`addr`=?,`rdate`=? where `custId`=?";
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getHp());
			psmt.setString(3, dto.getAddr());
			psmt.setString(4, dto.getRdate());
			psmt.setString(5, dto.getCustId());
			psmt.executeUpdate();
			closeAll();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public void deleteCustomer(String custId) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("delete from `customer` where `custId`=?");
			psmt.setString(1, custId);
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
