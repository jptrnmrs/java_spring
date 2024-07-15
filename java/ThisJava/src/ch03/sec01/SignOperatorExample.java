package ch03.sec01;
/*
 * 장제목 : 3장 부호/증감 연산자
 * 이름 : 최형욱
 * 작성일 : 2023.12.28
 */
public class SignOperatorExample {

	public static void main(String[] args) {
		int x = -100;
		x = -x;
		System.out.println("x: " + x);
		
		byte b = 100;
		int y = -b;
		System.out.println("y: " + y);
	}

}
