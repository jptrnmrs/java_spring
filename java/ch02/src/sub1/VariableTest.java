package sub1;
/*
 * 날짜 : 2024/06/28
 * 이름 : 김주경
 * 내용 : ch02.변수와 연산자
 */
public class VariableTest {
	public static void main(String[] args) {
	
		// 변수
		int a = 1; // 변수 선언과 초기화
		int b = 2;
		
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		
		a = 3; // 변수 재할당
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		
		
		// 상수
		
		final int NUM = 10; // 상수는 대문자로 표기
		
		//NUM = 7; 에러. 상수는 새로운 값으로 할당 안됨
		
		System.out.println("num : " + NUM);
	}
}
