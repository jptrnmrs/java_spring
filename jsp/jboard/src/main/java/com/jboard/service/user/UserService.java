package com.jboard.service.user;

import java.util.List;

import com.jboard.dao.UserDAO;
import com.jboard.dto.UserDTO;

public enum UserService {
	
	INSTANCE;
	
	private UserDAO dao = UserDAO.getInstance();
	
	public int selectCountUser(String type, String value) {
		return dao.selectCountUser(type, value);
	}
	public void insertUser(UserDTO dto) {
		dao.insertUser(dto);	
	}
	public UserDTO selectUser(String uid) {
		return dao.selectUser(uid);
	}
	public List<UserDTO> selectUsers() {
		return dao.selectUsers();
	}
	public void updateUser(UserDTO dto) {
		dao.updateUser(dto);
	}
	public void deleteUser(String uid) {
		dao.deleteUser(uid);
	}
}
