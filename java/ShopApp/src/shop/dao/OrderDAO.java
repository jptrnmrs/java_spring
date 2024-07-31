package shop.dao;

import java.util.ArrayList;
import java.util.List;

import shop.db.*;
import shop.vo.OrderVO;

public class OrderDAO extends DBHelper {
	private static OrderDAO instance = new OrderDAO();
	public static OrderDAO getInstance() {
		return instance;
	}
	private OrderDAO() {}
	
	public int insertOrder(OrderVO vo) {
		int count = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_ORDER);
			psmt.setString(1, vo.getOrderId());
			psmt.setInt(2, vo.getOrderProduct());
			psmt.setInt(3, vo.getOrderCount());
			count=psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public List<OrderVO> myOrder(String custId){
		List<OrderVO> orders = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ORDERS_BY_ORDERID);
			psmt.setString(1, custId);
			rs = psmt.executeQuery();
			while(rs.next()) {
				OrderVO vo = new OrderVO();
				vo.setOrderNo(rs.getInt(1));
				vo.setOrderProduct(rs.getInt(2));
				vo.setProdName(rs.getString(3));
				vo.setOrderCount(rs.getInt(4));
				vo.setOrderName(rs.getString(5));
				vo.setOrderDate(rs.getString(6));				
				orders.add(vo);
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}
}
