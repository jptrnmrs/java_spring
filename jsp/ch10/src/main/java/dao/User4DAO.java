package dao;

import java.util.ArrayList;
import java.util.List;

import dto.User4DTO;
import util.DBHelper;

public class User4DAO extends DBHelper{
	// 싱글톤
	private static User4DAO instance = new User4DAO();
	public static User4DAO getInstance() {
		return instance;
	}
	private User4DAO() {}
	
	// 기본 CRUD 메서드
	
	public void insertUser4(User4DTO dto) {
		String sql = "insert into `user4` value (?,?,?,?,?,?)";
		try {
			conn = getConnection();
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUid());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getGender());
			psmt.setInt(4, dto.getAge());
			psmt.setString(5, dto.getHp());
			psmt.setString(6, dto.getAddr());
			
			psmt.executeUpdate();
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public User4DTO selectUser4(String uid) {
		User4DTO dto = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("select * from `user4` where uid=?");
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new User4DTO();
				dto.setUid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setGender(rs.getString(3));
				dto.setAge(rs.getString(4));
				dto.setHp(rs.getString(5));
				dto.setAddr(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public List<User4DTO> selectUser4s() {
		List<User4DTO> users = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from `user4`");
			
			while(rs.next()) {
				User4DTO dto = new User4DTO();
				dto.setUid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setGender(rs.getString(3));
				dto.setAge(rs.getString(4));
				dto.setHp(rs.getString(5));
				dto.setAddr(rs.getString(6));
				
				users.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public void updateUser4(User4DTO dto) {
		String sql = "Update `user4` set `name`=?,`gender`=?,`age`=?,`hp`=?,`addr`=? where `uid`=?";
		try {
			conn = getConnection();
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getGender());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getHp());
			psmt.setString(5, dto.getAddr());
			psmt.setString(6, dto.getUid());
			
			psmt.executeUpdate();
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser4(String uid) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("delete from `user4` where `uid`=?");
			psmt.setString(1, uid);
			
			psmt.executeUpdate();
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
