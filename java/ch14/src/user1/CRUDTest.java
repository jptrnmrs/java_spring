package user1;

import java.util.List;
import java.util.Scanner;

/*
 * 날짜 : 2024. 7. 30.
 * 이름 : 김주경
 * 내용 : CRUD 실습
 */
public class CRUDTest {
	public static void main(String[] args) {
		System.out.println("------------------------------");
		System.out.println("   User1 회원 관리 매니저 v1.0");
		System.out.println("------------------------------");
		
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("종료:0, 입력:1, 조회:2, 검색:3, 수정:4, 삭제:5");
			System.out.print("선택> ");
			
			int ans = in.nextInt();
			in.nextLine();
			if(ans==0) {
				break;
			}else if(ans==1) {
				System.out.print("아이디 입력 : ");
				String uid = in.next().trim();
				System.out.print("이름 입력 : ");
				String name = in.next().trim();
				System.out.print("생일 입력 : ");
				String birth = in.next().trim();
				System.out.print("휴대폰 입력 : ");
				String hp = in.next().trim();
				System.out.print("나이 입력 : ");
				int age = in.nextInt();
				
				User1VO vo = new User1VO(uid, name, birth, hp, age);
				
				User1DAO dao = User1DAO.getInstance();
				dao.insertUser(vo);
				
				System.out.println("입력 완료");
			}else if(ans==2) {
				User1DAO dao = User1DAO.getInstance();
				List<User1VO> users = dao.selectUsers();
				for(User1VO vo : users) {
					System.out.println(vo);
				}
			}else if(ans==3) {
				System.out.print("검색 아이디 : ");
				String uid = in.next().trim();
				
				User1DAO dao = User1DAO.getInstance();
				User1VO user = dao.searchUser(uid);
				System.out.println(user);
			}else if(ans==4) {
				System.out.print("바꿀 아이디 : ");
				String uid = in.next().trim();
				User1DAO dao = User1DAO.getInstance();
				if(dao.searchUser(uid).getUid()==null) {
					System.out.println("선택한 아이디가 없습니다.");
					continue;
				}
				System.out.println("선택한 아이디" + dao.searchUser(uid));
				System.out.print("변경 이름 : ");
				String name = in.next().trim();
				System.out.print("변경 생일 : ");
				String birth = in.next().trim();
				System.out.print("변경 휴대폰 : ");
				String hp = in.next().trim();
				System.out.print("변경 나이 : ");
				int age = in.nextInt();
				
				User1VO vo = new User1VO(uid, name, birth, hp, age);
				
				dao.updateUser(vo);
				
			}else if(ans==5) {
				System.out.print("삭제할 아이디 : ");
				String uid = in.next().trim();
				User1DAO dao = User1DAO.getInstance();
				int result = dao.deleteUser(uid);
				
				if(result>0) System.out.println("삭제 완료되었습니다.");
				else System.out.println("잘못된 아이디입니다.");
			}else {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			
		}// while 끝
		in.close();
		System.out.println("프로그램 종료");
	}
}
