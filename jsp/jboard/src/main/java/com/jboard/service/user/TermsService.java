package com.jboard.service.user;

import java.util.List;

import com.jboard.dao.TermsDAO;
import com.jboard.dto.TermsDTO;

public enum TermsService {
	INSTANCE;
	private TermsDAO dao = TermsDAO.getInstance();

	public void insertTerms(TermsDTO dto) {
		dao.insertTerms(dto);
	}
	public TermsDTO selectTerms() {
		return dao.selectTerms();
	}
	public List<TermsDTO> selectAllTerms() {
		return dao.selectAllTerms();
	}
	public void updateTerms() {
		dao.updateTerms();
	}
	public void deleteTerms() {
		dao.deleteTerms();
	}
}
