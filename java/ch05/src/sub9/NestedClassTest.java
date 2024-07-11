package sub9;
/*
 * 날짜 : 2024/07/11
 * 이름 : 김주경
 * 내용 : 중첩 클래스 실습
 */

// 외부클래스
class Outer{
	
	private int x;
	
	public Outer(int x) {
		this.x = x;
	}
	public void show() {
		System.out.println("outer : " + x);
	}
	
	// 내부클래스
	class Inner{
		private int x;

		public Inner(int x) {
			this.x = x;
		}
		
		public void show() {
			System.out.println("inner : " + x);
		}
		
	}
}
interface Person{
	public void hello();
}


public class NestedClassTest {
	public static void main(String[] args) {
		// 외부 객체 생성
		Outer out = new Outer(1);
		out.show();
		// 내부 객체 생성
		Outer.Inner inn = out.new Inner(2);
		inn.show();
		// 익명 객체 실습 - 인터페이스를 클래스 구현 없이 바로 new 생성한 객체
		Person p = new Person() {
			
			@Override
			public void hello() {
				System.out.println("Person Hello..");
				
			}
		};
		p.hello();
	}
}
