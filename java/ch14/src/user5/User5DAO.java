package user5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import user1.User1VO;

public class User5DAO {

	// 싱글톤
	private static User5DAO instance = new User5DAO();
	public static User5DAO getInstance() {
		return instance;
	}
	private User5DAO() {}
	
	// DB 정보
	private final static String HOST = "jdbc:mysql://localhost:3306/studydb";
	private final static String USER = "root";
	private final static String PASS = "1234";
	
	public void insertUser(User5VO vo) {
		String sql = "insert into `user5`(`name`,`gender`,`age`,`addr`) values (?,?,?,?)";
		try {
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getName());
			psmt.setString(2, vo.getGender());
			psmt.setInt(3, vo.getAge());
			psmt.setString(4, vo.getAddr());
			psmt.executeUpdate();
			psmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<User5VO> selectUsers() {
		List<User5VO> users = new ArrayList<>();
		String sql = "select * from `user5`";
		try {
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				User5VO vo = new User5VO();
				vo.setSeq(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setGender(rs.getString(3));
				vo.setAge(rs.getInt(4));
				vo.setAddr(rs.getString(5));
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
	
	public User5VO searchUser(String name) {
		User5VO user = new User5VO();
		String sql = "select * from `user5` where `name` =?";
		try {
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				user.setSeq(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setGender(rs.getString(3));
				user.setAge(rs.getInt(4));
				user.setAddr(rs.getString(5));
			}
			
			rs.close();
			psmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public int updateUser(User5VO vo) {
		int result = 0;
		String sql = "update `user5` set `name`=?, `gender`=?, `age`=?, `addr`=? where `seq`=?";
		try {
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getName());
			psmt.setString(2, vo.getGender());
			psmt.setInt(3, vo.getAge());
			psmt.setString(4, vo.getAddr());
			psmt.setInt(5, vo.getSeq());
			
			result = psmt.executeUpdate();

			psmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteUser(String name) {
		int result = 0;
		String sql = "delete from `user5` where `name` =?";
		try {
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			result = psmt.executeUpdate();

			psmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
