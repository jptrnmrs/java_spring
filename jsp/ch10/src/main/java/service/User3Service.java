package service;

import java.util.List;

import dao.User3DAO;
import dto.User3DTO;

public class User3Service {

	private static User3Service instance = new User3Service();
	public static User3Service getInstance() {
		return instance;
	}
	private User3Service() {}
	
	// DAO 인스턴스
	private User3DAO dao = User3DAO.getInstance();
	
	public void insertUser3(User3DTO dto) {
			dao.insertUser3(dto);
	}
	public User3DTO selectUser3(String uid) {
		return dao.selectUser3(uid);
	}
	public List<User3DTO> selectUser3s() {
		return dao.selectUser3s();
	}
	public void updateUser3(User3DTO dto) {
		dao.updateUser3(dto);
	}
	public void deleteUser3(String uid) {
		dao.deleteUser3(uid);
	}
}
