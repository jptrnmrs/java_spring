package user5;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class User5Main {
	public static void main(String[] args) {
		System.out.println("------------------------------");
		System.out.println("   User5 회원 관리 매니저 v1.0");
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
				System.out.print("이름 입력 : ");
				String name = in.nextLine().trim();
				System.out.print("성별 입력 : ");
				String birth = in.nextLine().trim();
				System.out.print("주소 입력 : ");
				String addr = in.nextLine();
				System.out.print("나이 입력 : ");
				int age = in.nextInt();
				
				User5VO user = new User5VO(name, birth, age, addr);
				User5DAO dao = User5DAO.getInstance();
				dao.insertUser(user);
				System.out.println("등록되었습니다.");
			}else if(ans==2) {
				User5DAO dao = User5DAO.getInstance();
				List<User5VO> users = dao.selectUsers();
				for(User5VO user : users) System.out.println(user);
			}else if(ans==3) {

				System.out.print("찾을 이름 입력 : ");
				String name = in.next();
				User5DAO dao = User5DAO.getInstance();
				User5VO user = dao.searchUser(name);
				if(user.getName().isEmpty())System.out.println("없는 회원입니다.");
				else System.out.println(user);
				
			}else if(ans==4) {
				System.out.print("회원 번호 입력 : ");
				int seq = in.nextInt();
				in.nextLine();
				System.out.print("이름 입력 : ");
				String name = in.nextLine().trim();
				System.out.print("성별 입력 : ");
				String birth = in.nextLine().trim();
				System.out.print("주소 입력 : ");
				String addr = in.nextLine();
				System.out.print("나이 입력 : ");
				int age = in.nextInt();
				
				User5VO user = new User5VO(seq,name, birth, age, addr);
				User5DAO dao = User5DAO.getInstance();
				int result = dao.updateUser(user);
				if(result>0) System.out.println("변경되었습니다.");
				else System.out.println("없는 아이디입니다.");
			}else if(ans==5) {
				
				System.out.print("삭제할 회원 이름 입력 : ");
				String name = in.next();
				User5DAO dao = User5DAO.getInstance();
				int result = dao.deleteUser(name);
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
