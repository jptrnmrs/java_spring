package sub5;
/*
 * 날짜 : 2024/07/10
 * 이름 : 김주경
 * 내용 : 메서드 오버라이딩 실습
 */
class AAA{
	public void method1() { 
		System.out.println("AAA::Method1...");
		}
	public void method2() { 
		System.out.println("AAA::Method2...");
		}
	public void method3() { 
		System.out.println("AAA::Method3...");
		}
}
class BBB extends AAA {
	
	@Override				// 오버라이드 메서드 표시 (기능X)
	public void method2() {
		System.out.println("BBB::Method2...");
		}
	
	public void method3(int a) { 
		System.out.println("BBB::Method3...");
		}
}
class CCC extends BBB{
	
	@Override				// 오버라이드 메서드 표시 (기능X)
	public void method1() { 
		System.out.println("CCC::Method1...");
		}
	
	@Override				// 오버라이드 메서드 표시 (기능X)
	public void method2() { 
		System.out.println("CCC::Method2...");
		}
	
	public void method3(int a, int b) { 
		System.out.println("CCC::Method3...");
		}
}
public class MethodOverrideTest {
	public static void main(String[] args) {
		CCC c = new CCC();
		
		// 메서드 오버라이딩 (상속받은 자식 클래스에서 재정의됨)
		c.method1();
		c.method2();
		
		// 메서드 오버로딩 (매개인수가 달라 각자 다른 메서드로 인식)
		c.method3();
		c.method3(1);
		c.method3(1,2);
		
		//car 클래스 메서드 재정의
		Sedan sonata = new Sedan("소나타","흰색",0,2000);
		sonata.speedUp(100);
		sonata.show();
		
		Truck bongo = new Truck("봉고","남색",0,1000);
		bongo.speedUp(100);
		bongo.show();
		
		
	}
}
