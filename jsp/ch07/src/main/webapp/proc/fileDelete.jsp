<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.File"%>
<%@page import="sub1.FileVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String no = request.getParameter("no");
	String sname = request.getParameter("sname");
	try{
		
		Context ctx = (Context) new InitialContext().lookup("java:comp/env");
		DataSource ds = (DataSource) ctx.lookup("jdbc/studydb");
		Connection conn = ds.getConnection();
		
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("delete from `filetest` where `no`="+no);
		stmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	try{		
		String path = application.getRealPath("/uploads");
		File file = new File(path + File.separator + sname);
		file.delete();
	}catch(Exception e){
		e.printStackTrace();
	}
	response.sendRedirect("../2.fileDownloadTest.jsp");
%>
