package com.jboard.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jboard.dto.FileDTO;
import com.jboard.util.DBHelper;
import com.jboard.util.SQL;

public class FileDAO extends DBHelper{

	private static FileDAO instance = new FileDAO();
	public static FileDAO getInstance() {
		return instance;
	}
	private FileDAO() {}
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public List<FileDTO> selectArticleFile(int ano) {
		List<FileDTO> files = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_FILE_FOR_ARTICLE);
			psmt.setInt(1, ano);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				FileDTO file = new FileDTO();
				file.setFno(rs.getInt(1));
				file.setAno(rs.getInt(2));
				file.setoName(rs.getString(3));
				file.setsName(rs.getString(4));
				file.setDownload(rs.getInt(5));
				file.setRdate(rs.getString(6));
				files.add(file);
			}
			
			closeAll();
					
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return files;
	}
	public void insertFile(FileDTO file) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_FILE);
			psmt.setInt(1, file.getAno());
			psmt.setString(2, file.getoName());
			psmt.setString(3, file.getsName());
			psmt.executeUpdate();
			closeAll();
					
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	public FileDTO selectFile(int fno) {
		FileDTO file = null;
		return file;
	}
	public List<FileDTO> selectFiles() {
		List<FileDTO> files = new ArrayList<>();
		return files;
	}
	public void updateFile(FileDTO file) {
		
	}
	public void deleteFile(int fno) {
		
	}
	
}
