package test5;

/*
 * 날짜 : 2024. 8. 1.
 * 이름 : 김주경
 * 내용 : 자바 총정리 연습문제
 * 
 * 원주율
 * - π = 4x( 1/1 - 1/3 + 1/5 - 1/7 + 1/9 -1/11 + ...)
 * - 항수가 늘어날 수록 정확도가 높아진다.
 */
public class Test05 {
	public static void main(String[] args) {
		boolean sign = false;
		double pi = 0;
		
		for(int i=1; i<=10000000;i+=2) {
			if(!sign) {
				pi +=1.0/i;
				sign=true;
			}else {
				pi -=1.0/i;
				sign=false;
				
			}
			System.out.printf("i = %d, PI = %f\n",i,4*pi);
		}
		
		
	}
}
