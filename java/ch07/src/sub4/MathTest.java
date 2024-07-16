package sub4;

/*
 * 날짜 : 2024. 7. 16.
 * 이름 : 김주경
 * 내용 : 자바 Math 클래스 실습
 */
public class MathTest {
	public static void main(String[] args) {
		// Math 는 정적 메서드로 제공하기 때문에 객체 생성 필요없음
//		Math math = new Math();
		
		// 기본 메서드
		System.out.println("절대값 : " + Math.abs(-5));
		System.out.println("제곱근 : " + Math.sqrt(9));
		System.out.println("올림값 : " + Math.ceil(1.2));
		System.out.println("올림값 : " + Math.ceil(1.8));
		System.out.println("내림값 : " + Math.floor(1.2));
		System.out.println("내림값 : " + Math.floor(1.8));
		System.out.println("반올림 : " + Math.round(1.2));
		System.out.println("반올림 : " + Math.round(1.8));
		
		//random 메서드
		double num1 = Math.random();			//0에서 1 사이의 실수
		System.out.println("num1 : " + num1);

		double num2 = num1*10;					//0에서 10 사이의 실수
		System.out.println("num2 : " + num2);
		
		double num3 = Math.ceil(num2);
		System.out.println("num3 : " + num3);
		
		// 1 ~ 46 사이 정수
		double rand = Math.ceil(Math.random()*46);
		System.out.println("rand : " + rand);
	}
}
