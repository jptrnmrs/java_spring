package sub1;
/*
 * 날짜 : 2024/07/08
 * 이름 : 김주경
 * 내용 : 클래스와 객체 실습
 */

public class ClassTest {
	
	public static void main(String[] args) {
		
		// 객체 생성
		Car sonata = new Car(); // (참조타입)클래스 + 변수명 = new 클래스();
		
		// 객체 초기화
		sonata.name = "소나타";
		sonata.color = "흰색";
		sonata.speed = 0;

		// 객체 활용(상호작용)
		sonata.speedUp(100);
		sonata.speedDown(20);
		sonata.show();
		
		System.out.println("---------------------");
		
		// 객체 생성
		Car avante = new Car(); // (참조타입)클래스 + 변수명 = new 클래스();
		
		// 객체 초기화
		avante.name = "아반테";
		avante.color = "검정";
		avante.speed = 0;

		// 객체 활용(상호작용)
		avante.speedUp(80);
		avante.speedDown(20);
		avante.show();

		System.out.println("---------------------");
		
		Account kb = new Account();
		
		kb.bank = "국민은행";
		kb.acc = "101-21-1001";
		kb.name = "김유신";
		kb.balance = 10000;
		
		kb.deposit(40000);
		kb.withdraw(30000);
		kb.show();
		
		System.out.println("---------------------");
		
		Account wr = new Account();
		
		wr.bank= "우리은행";
		wr.acc= "101-22-1001";
		wr.name= "김춘추";
		wr.balance= 10000;
		
		wr.deposit(20000);
		wr.withdraw(15000);
		wr.show();
		
	}
}
