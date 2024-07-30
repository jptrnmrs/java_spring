package user3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class User3DAO {

	// 싱글톤
	
	private static User3DAO instance = new User3DAO();
	public static User3DAO getInstance() {
		return instance;
	}
	private User3DAO() {}
	
	// DB 정보
	private final static String HOST = "jdbc:mysql://localhost:3306/studydb";
	private final static String USER = "root";
	private final static String PASS = "1234";
	
	public void insertUser(User3VO vo) {
		String sql = "";
		try {
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<User3VO> selectUsers() {
		List<User3VO> users = new ArrayList<>();
		String sql = "";
		try {
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return users;
	}
	
	public User3VO searchUser(String uid) {
		User3VO user = null;
		String sql = "";
		try {
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public int updateUser(User3VO vo) {
		int result = 0;
		String sql = "";
		try {
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteUser(String uid) {
		int result = 0;
		String sql = "";
		try {
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
