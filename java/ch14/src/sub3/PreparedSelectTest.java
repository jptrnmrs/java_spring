package sub3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * 날짜 : 2024. 7. 29.
 * 이름 : 김주경
 * 내용 : PreparedStatement 실습
 */
public class PreparedSelectTest {
	public static void main(String[] args) {

		// DB 정보
		String host = "jdbc:mysql://127.0.0.1:3306/studydb";
		String user = "root";
		String pass = "1234";
		
		List<User2VO> user2s = new ArrayList<User2VO>();
		try {
			// 1단계 - 데이터베이스 접속
			Connection conn = DriverManager.getConnection(host, user, pass);
			
			// 2단계 - SQL 실행 객체(PreparedStatement) 생성
			String sql = "select * from `User2`";
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			// 3단계 - SQL 실행
			ResultSet rs = psmt.executeQuery();
			
			// 4단계 - ResultSet 결과 처리
			while(rs.next()) {
				User2VO vo = new User2VO();
				vo.setUid(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setBirth(rs.getString(3));
				vo.setAddr(rs.getString(4));
				
				user2s.add(vo);
			}
			// 5단계 - 데이터베이스 종료
			rs.close();
			psmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(User2VO vo : user2s) {
			System.out.println(vo);
		}
		
		System.out.println("selected");
	}
}
