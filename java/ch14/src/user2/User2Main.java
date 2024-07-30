package user2;

import java.util.Scanner;

import user4.User4VO;

public class User2Main {
	public static void main(String[] args) {
		System.out.println("------------------------------");
		System.out.println("   User2 회원 관리 매니저 v1.0");
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
				System.out.print("생일 입력 : ");
				String birth = in.next();
				System.out.print("주소 입력 : ");
				String addr = in.next();
				
				User2VO user = new User2VO(uid, name, birth, addr);
				User2DAO dao = User2DAO.getInstance();
				dao.insertUser(user);
			}else if(ans==2) {

				User2DAO dao = User2DAO.getInstance();
				dao.selectUsers();
			}else if(ans==3) {

				System.out.print("찾을 아이디 입력 : ");
				String uid = in.next();
				User2DAO dao = User2DAO.getInstance();
				User2VO user = dao.searchUser(uid);
				if(user.getUid()==null)System.out.println("없는 아이디입니다.");
				else System.out.println(user);
				
			}else if(ans==4) {
				User2VO user = null;
				User2DAO dao = User2DAO.getInstance();
				int result = dao.updateUser(user);
			}else if(ans==5) {
				
				System.out.print("삭제할 아이디 입력 : ");
				String uid = in.next();
				User2DAO dao = User2DAO.getInstance();
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
