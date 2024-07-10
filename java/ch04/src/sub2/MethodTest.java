package sub2;
/*
 * 날짜 : 2024/07/02
 * 이름 : 김주경
 * 내용 : JAVA 메서드 실습
 */

public class MethodTest {
	public static void main(String[] args) {
		//메서드 호출(call)
		int y1 = f(1);
		int y2 = f(2);
		int y3 = f(3);
		System.out.println("y1 : "+y1);
		System.out.println("y2 : "+y2);
		System.out.println("y3 : "+y3);
		
		int sum1 = sum(1,10);
		System.out.println("1부터 10까지의 합 : " + sum1);
	}
	
	public static int f(int x) {
		int y = 2*x+3;
		return y;
	}
	public static int sum(int start, int end) {
		int total = 0;
		for (int k = start ; k<=end ; k++) {
			total += k;
		}
		return total;
	}
}
