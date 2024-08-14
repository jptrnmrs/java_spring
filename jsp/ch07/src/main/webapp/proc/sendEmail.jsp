<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.PasswordAuthentication"%>
<%@page import="javax.mail.Authenticator"%>
<%@page import="javax.mail.Session"%>
<%@page import="java.util.Properties"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 기본정보
	String sender = request.getParameter("sender");
	String receiver = request.getParameter("receiver");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String appPass = "mtri mlkb aqev wium"; // Google 앱 비밀번호
	
	// SMTP 설정 (고정값)
	Properties props = new Properties();
	props.put("mail.smtp.host","smtp.gmail.com");
	props.put("mail.smtp.port","465");
	props.put("mail.smtp.auth","true");
	props.put("mail.smtp.ssl.enable","true");
	props.put("mail.smtp.ssl.trust","smtp.gmail.com");
	
	// gmail session 생성
	Session gmailSession = Session.getInstance(props,new Authenticator(){
		@Override
		protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
			return new PasswordAuthentication(sender,appPass);
		}
	});
	
	// 메일 발송
	Message message = new MimeMessage(gmailSession);
		// 송신자 설정
	message.setFrom(new InternetAddress(sender,"보내는 사람","UTF-8"));
		// 수신자 설정
	message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
	message.setSubject(title); // 제목 설정
	message.setContent(content,"text/html;charset=utf-8"); // 내용 설정
	Transport.send(message);
	
	// 이메일 입력 폼 이동
	response.sendRedirect("../3.emailTest.jsp");
%>