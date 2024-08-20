package com.jboard.service.user;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jboard.dao.UserDAO;
import com.jboard.dto.UserDTO;

public enum UserService {
	
	INSTANCE;
	
	private UserDAO dao = UserDAO.getInstance();
	private Logger logger = LoggerFactory.getLogger(this.name());
	
	public String sendEmailCode(String email) {
		//인증코드 생성
		int code = ThreadLocalRandom.current().nextInt(100000, 1000000);
		
		
		String title = "JBoard 가입 인증 번호입니다.";
		String content ="<h4> 인증코드는 " + code + "입니다.<h4>";
		String sender = "jptrnmrs@gmail.com";
		String appPass = "diog dhjo yxdt gcpb"; // Google 앱 비밀번호
		
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
		try {
			// 송신자 설정
			message.setFrom(new InternetAddress(sender,"JBoard","UTF-8"));
			// 수신자 설정
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject(title); // 제목 설정
			message.setContent(content,"text/html;charset=utf-8"); // 내용 설정
			Transport.send(message);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return ""+code;
		
	}
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
