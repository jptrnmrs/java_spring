package com.jboard.service.article;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jboard.dao.FileDAO;
import com.jboard.dto.FileDTO;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

public enum FileService {
	
	INSTANCE;
	
	private FileDAO dao = FileDAO.getInstance();
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public List<FileDTO> fileUpload(HttpServletRequest req) {
		
		List<FileDTO> files = new ArrayList<>();
		
		ServletContext ctx = req.getServletContext();
		String uploadPath = ctx.getRealPath("/uploads");
		logger.debug("uploadPath : " +uploadPath);
		
		try {
			Collection<Part> parts = req.getParts(); // 첨부파일 정보객체 가져오기
			
			for(Part part : parts) {
				// 파일명 추출
				String oFileName = part.getSubmittedFileName();
				
				// 첨부된 파일이 있으면
				if(oFileName != null && !oFileName.isEmpty()) {
					logger.debug("oFileName : " + oFileName);
					
					// 고유 파일명 생성
					int idx = oFileName.lastIndexOf(".");
					String ext = oFileName.substring(idx);
					String sFileName = UUID.randomUUID().toString()+ext;

					logger.debug("sFileName : " + sFileName);
					// 파일 저장
					part.write(uploadPath + File.separator + sFileName);

					// filDTO 생성
					FileDTO file = new FileDTO();
					file.setoName(oFileName);
					file.setsName(sFileName);
					files.add(file);
				}
			}
		} catch (IOException | ServletException e) {
			logger.error(e.getMessage());
		}
		
		return files;
	}
	public void fileDownload(HttpServletRequest req, HttpServletResponse resp) {
		
		FileDTO fileDTO = (FileDTO) req.getAttribute("file");
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			// response 헤더정보 수정
			resp.setContentType("application/octet-stream");
			resp.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(fileDTO.getoName(), "utf-8"));
			resp.setHeader("Content-Transfer-Encoding", "binary");
			resp.setHeader("Pragma", "no-cache");
			resp.setHeader("Cache-Control", "private");
			
			// 파일 내용 스트림 처리
			ServletContext ctx = req.getServletContext();
			String path = ctx.getRealPath("/uploads");
			File file = new File(path + File.separator+fileDTO.getsName());
			
			bis = new BufferedInputStream(new FileInputStream(file));
			bos = new BufferedOutputStream(resp.getOutputStream());
			
			bis.transferTo(bos);
			bos.flush();
			bis.close();
			bos.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	
	public void insertFile(FileDTO file) {
		dao.insertFile(file);
	}
	public FileDTO selectFile(String fno) {
		return dao.selectFile(fno);
	}
	public List<FileDTO> selectFiles() {
		return dao.selectFiles();
	}
	public void updateFile(FileDTO file) {
		dao.updateFile(file);
	}
	public void updateFileDownloadCount(String fno) {
		dao.updateFileDownloadCount(fno);
	}
	public void deleteFile(int fno) {
		dao.deleteFile(fno);
	}
}
