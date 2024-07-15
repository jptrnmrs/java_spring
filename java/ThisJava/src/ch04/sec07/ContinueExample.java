package ch04.sec07;
/*
 * 장제목 : 4장 break 문 
 * 이름 : 최형욱
 * 작성일 : 2024.01.03
 */
public class ContinueExample {
	public static void main(String[] args) throws Exception{
		for(int i=1; i<=10; i++) {
			if(i%2 != 0) {	// 2로 나눈 나머지가 0이 아닐 경우, 즉 홀수인 경우
				continue;
			}
			System.out.println(i + " ");	// 홀수는 실행되지 않는다.
		}
	}
}
