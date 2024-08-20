package com.jboard.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jboard.dto.TermsDTO;
import com.jboard.util.DBHelper;
import com.jboard.util.SQL;

public class TermsDAO extends DBHelper{
	private static TermsDAO instance = new TermsDAO();
	public static TermsDAO getInstance() {
		return instance;
	}
	private TermsDAO() {}
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	
	public void insertTerms(TermsDTO dto) {}
	
	public TermsDTO selectTerms() {
		TermsDTO terms = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_TERMS);
			if(rs.next()) {
				terms = new TermsDTO();
				terms.setTerms(rs.getString(1));
				terms.setPrivacy(rs.getString(2));
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return terms;
	}
	
	public List<TermsDTO> selectAllTerms() {
		List<TermsDTO> AllTerms = new ArrayList<>();
		return AllTerms;
	}
	public void updateTerms() {}
	public void deleteTerms() {}

}
