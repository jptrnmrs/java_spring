package user4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class User4DAO {

	// 싱글톤
	
	private static User4DAO instance = new User4DAO();
	public static User4DAO getInstance() {
		return instance;
	}
	private User4DAO() {}
	
	// DB 정보
	private final static String HOST = "jdbc:mysql://localhost:3306/studydb";
	private final static String USER = "root";
	private final static String PASS = "1234";
	
	public void insertUser(User4VO vo) {
		String sql = "";
		try {
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<User4VO> selectUsers() {
		List<User4VO> users = new ArrayList<>();
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
	
	public User4VO searchUser(String uid) {
		User4VO user = null;
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
	
	public int updateUser(User4VO vo) {
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
