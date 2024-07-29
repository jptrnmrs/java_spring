package sub3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*
 * 날짜 : 2024. 7. 29.
 * 이름 : 김주경
 * 내용 : PreparedStatement 실습
 */
public class PreparedUpdateTest {
	public static void main(String[] args) {
		

		// DB 정보
		String host = "jdbc:mysql://127.0.0.1:3306/studydb";
		String user = "root";
		String pass = "1234";
		
		// J101 김철시 부산광역시
		try {
			// 1단계 - 데이터베이스 접속
			Connection conn = DriverManager.getConnection(host, user, pass);
			
			// 2단계 - SQL 실행 객체(PreparedStatement) 생성
			String sql = "update `user2` set `name`=?, `addr`=? where `uid` = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			// 3단계 - SQL 실행
			psmt.setString(1, "김철수");
			psmt.setString(2, "부산시");
			psmt.setString(3, "J101");
			psmt.executeUpdate();
			// 4단계 - ResultSet 결과 처리
			// 5단계 - 데이터베이스 종료
			psmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("updated");
	}
}
