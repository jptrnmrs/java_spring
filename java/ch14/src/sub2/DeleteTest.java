package sub2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 * 날짜 : 2024. 7. 29.
 * 이름 : 김주경
 * 내용 : Delete 실습
 */
public class DeleteTest {
	public static void main(String[] args) {
		
		// 아이디 J101삭제하기

		// DB 정보
		String host = "jdbc:mysql://127.0.0.1:3306/studydb";
		String user = "root";
		String pass = "1234";

		try {

			Connection conn =  DriverManager.getConnection(host, user, pass);
			Statement stmt = conn.createStatement();
			
			String sql = "delete from `user1` where `uid` = 'J101'";

			stmt.executeUpdate(sql);
			
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
