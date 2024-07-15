package sub2;

import java.util.Scanner;

/*
 * 날짜 : 2024/07/15
 * 이름 : 김주경
 * 내용 : 예외 던지기 실습
 * 
 * 
 */
public class ThrowsTest {
	public static void main(String[] args) {
		
		int num = 1;
		
		try {
//			method1에서 예외가 발생하면 예외 처리
			method1(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("프로그램 종료...");
	}
	// method1에서 예외가 발생하면 method1을 호출하는 곳으로 예외 던지기
	public static void method1(int num) throws Exception{
		method2(num);
	}
	// method2에서 예외가 발생하면 method2를 호출하는 곳으로 예외 던지기
	public static void method2(int num) throws Exception { // 업캐스팅 (다형성
		Scanner scan = new Scanner(System.in);
		System.out.print("num2 입력 : ");
		int num2 = scan.nextInt();		// 예외 발생 가능 InputMissmatchException
		int result = num / num2;		// 예외 발생 가능 ArithmeticException
		
		System.out.println("result : " + result);
		scan.close();
	}
}
