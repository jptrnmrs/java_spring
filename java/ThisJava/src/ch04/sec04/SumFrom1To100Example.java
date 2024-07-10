package ch04.sec04;

public class SumFrom1To100Example {
	public static void main(String[] args) {
		int sum= 0;
		int i;
		
		for(i=1;i<=100;i++) {
			sum+=i;
		}
		System.out.printf("1~%d 합 : %d",i-1,sum);
	}
}
