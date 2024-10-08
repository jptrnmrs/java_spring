package service;

import java.util.List;

import dao.User4DAO;
import dto.User4DTO;

public class User4Service {

	private static User4Service instance = new User4Service();
	public static User4Service getInstance() {
		return instance;
	}
	private User4Service() {}
	
	// DAO 인스턴스
	private User4DAO dao = User4DAO.getInstance();
	
	public void insertUser4(User4DTO dto) {
			dao.insertUser4(dto);
	}
	public User4DTO selectUser4(String uid) {
		return dao.selectUser4(uid);
	}
	public List<User4DTO> selectUser4s() {
		return dao.selectUser4s();
	}
	public void updateUser4(User4DTO dto) {
		dao.updateUser4(dto);
	}
	public void deleteUser4(String uid) {
		dao.deleteUser4(uid);
	}
}
