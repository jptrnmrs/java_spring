package user4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
		String sql = "insert into `user4` values (?,?,?,?,?,?)";
		try {
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUid());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getGender());
			psmt.setInt(4, vo.getAge());
			psmt.setString(5, vo.getHp());
			psmt.setString(6, vo.getAddr());
			psmt.executeUpdate();
			psmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<User4VO> selectUsers() {
		List<User4VO> users = new ArrayList<>();
		String sql = "select * from `user4`";
		try {
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				User4VO vo = new User4VO();
				vo.setUid(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setGender(rs.getString(3));
				vo.setAge(rs.getInt(4));
				vo.setHp(rs.getString(5));
				vo.setAddr(rs.getString(6));
				users.add(vo);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public User4VO searchUser(String uid) {
		User4VO user = null;
		String sql = "select * from `user4` where `uid`=?";
		try {
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, uid);
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				User4VO vo = new User4VO();
				vo.setUid(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setGender(rs.getString(3));
				vo.setAge(rs.getInt(4));
				vo.setHp(rs.getString(5));
				vo.setAddr(rs.getString(6));
				user = vo;
			}
			rs.close();
			psmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public int updateUser(User4VO vo) {
		int result = 0;
		String sql = "update `user4` set `name`=?, `gender`=?, `age`=?, `hp`=?, `addr`=? where `uid`=?";
		try {
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUid());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getGender());
			psmt.setInt(4, vo.getAge());
			psmt.setString(5, vo.getHp());
			psmt.setString(6, vo.getAddr());
			result = psmt.executeUpdate();
			psmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteUser(String uid) {
		int result = 0;
		String sql = "delete from `user4` where `uid`=?";
		try {
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, uid);
			result = psmt.executeUpdate();
			psmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
