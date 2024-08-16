package dao;

import java.util.ArrayList;
import java.util.List;

import dto.User5DTO;
import util.DBHelper;

public class User5DAO extends DBHelper{
	// 싱글톤
	private static User5DAO instance = new User5DAO();
	public static User5DAO getInstance() {
		return instance;
	}
	private User5DAO() {}
	
	// 기본 CRUD 메서드
	
	public void insertUser5(User5DTO dto) {
		String sql = "Insert into `user5` set `name`=?,`gender`=?,`age`=?,`addr`=?";
		try {
			conn = getConnection();
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getGender());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getAddr());
			
			psmt.executeUpdate();
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public User5DTO selectUser5(String seq) {
		User5DTO dto = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("select * from `user5` where seq=?");
			psmt.setString(1, seq);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new User5DTO();
				dto.setSeq(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setGender(rs.getString(3));
				dto.setAge(rs.getString(4));
				dto.setAddr(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public List<User5DTO> selectUser5s() {
		List<User5DTO> users = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from `user5`");
			
			while(rs.next()) {
				User5DTO dto = new User5DTO();
				dto.setSeq(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setGender(rs.getString(3));
				dto.setAge(rs.getString(4));
				dto.setAddr(rs.getString(5));
				
				users.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public void updateUser5(User5DTO dto) {
		String sql = "Update `user5` set `name`=?,`gender`=?,`age`=?,`addr`=? where `seq`=?";
		try {
			conn = getConnection();
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getGender());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getAddr());
			psmt.setInt(5, dto.getSeq());
			
			psmt.executeUpdate();
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser5(String seq) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("delete from `user5` where `seq`=?");
			psmt.setString(1, seq);
			
			psmt.executeUpdate();
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
