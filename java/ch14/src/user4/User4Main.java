package user4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class User4Main {
	public static void main(String[] args) {
		System.out.println("------------------------------");
		System.out.println("   User4 회원 관리 매니저 v1.0");
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
				String uid = in.next();
				System.out.print("이름 입력 : ");
				String name = in.next();
				System.out.print("성별 입력 : ");
				String birth = in.next();
				System.out.print("나이 입력 : ");
				int age = in.nextInt();
				System.out.print("핸드폰 입력 : ");
				String hp = in.next();
				System.out.print("주소 입력 : ");
				String addr = in.next();
				
				User4VO user = new User4VO(uid, name, birth, age, hp, addr);
				User4DAO dao = User4DAO.getInstance();
				dao.insertUser(user);
				
			}else if(ans==2) {
				
				List<User4VO> users = new ArrayList<>();
				User4DAO dao = User4DAO.getInstance();
				dao.selectUsers();
				
				for(User4VO user : users) {
					System.out.println(user);
				}
				
			}else if(ans==3) {

				System.out.print("찾을 아이디 입력 : ");
				String uid = in.next();
				
				User4DAO dao = User4DAO.getInstance();
				User4VO user = dao.searchUser(uid);
				
				if(user.getUid()==null)System.out.println("없는 아이디입니다.");
				else System.out.println(user);
				
			}else if(ans==4) {
				System.out.print("변경할 아이디 : ");
				String uid = in.next();
				System.out.print("수정할 이름 : ");
				String name = in.next();
				System.out.print("수정할 성별 : ");
				String birth = in.next();
				System.out.print("수정할 나이 : ");
				int age = in.nextInt();
				System.out.print("수정할 핸드폰 : ");
				String hp = in.next();
				System.out.print("수정할 주소 : ");
				String addr = in.next();
				
				User4VO user = new User4VO(uid, name, birth, age, hp, addr);
				User4DAO dao = User4DAO.getInstance();
				
				int result = dao.updateUser(user);
				
				if(result>0) System.out.println("변경되었습니다.");
				else System.out.println("없는 아이디입니다.");
				
			}else if(ans==5) {
				
				System.out.print("삭제할 아이디 입력 : ");
				
				String uid = in.next();
				User4DAO dao = User4DAO.getInstance();
				
				int result = dao.deleteUser(uid);
				
				if(result>0) System.out.println("삭제되었습니다.");
				else System.out.println("없는 아이디입니다.");
				
			}else {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
		}
		in.close();
		System.out.println("프로그램 종료");
	}
}
