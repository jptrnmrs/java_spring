package shop.dao;

import java.util.ArrayList;
import java.util.List;

import shop.db.*;
import shop.vo.ProductVO;

public class ProductDAO extends DBHelper {
	private static ProductDAO instance = new ProductDAO();
	public static ProductDAO getInstance() {
		return instance;
	}
	private ProductDAO() {}
	
	public List<ProductVO> showProduct() {
		List<ProductVO> list = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_PRODUCT);
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setProdNo(rs.getInt(1));
				vo.setProdName(rs.getString(2));
				vo.setStock(rs.getInt(3));
				vo.setPrice(rs.getInt(4));
				vo.setCompany(rs.getString(5));
				list.add(vo);
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
