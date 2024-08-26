package com.jboard.controller.article;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jboard.dto.FileDTO;
import com.jboard.service.article.FileService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/article/fileDownload.do")
public class FileDownloadController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private FileService service = FileService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fno = req.getParameter("fno");
		
		FileDTO file = service.selectFile(fno);
		
		// 공유참조
		req.setAttribute("file", file);
		
		logger.debug(file.toString());
		service.fileDownload(req, resp);
		service.updateFileDownloadCount(fno);
		
	}
}
