package sub1;
/*
 * 날짜 : 2024/07/02
 * 이름 : 김주경
 * 내용 : JAVA 배열 실습
 */
public class ArrayTest {
	public static void main(String[] args) {
		// 배열
		int[] arr1 = {1,2,3,4,5};
		char[] arr2 = {'A','B','C'};
		String[] arr3 = {"서울", "대전", "광주", "대구","부산"};
		
		// 배열 원소
		System.out.println("arr1[0] : "+arr1[0]);
		System.out.println("arr1[1] : "+arr1[1]);
		System.out.println("arr1[2] : "+arr1[2]);

		System.out.println("arr2[0] : "+arr2[0]);
		System.out.println("arr2[2] : "+arr2[2]);

		System.out.println("arr3[0] : "+arr3[0]);
		System.out.println("arr3[3] : "+arr3[3]);
		System.out.println("arr3[4] : "+arr3[4]);
		
		// 배열 길이
		
		System.out.println("arr1 배열길이 : " + arr1.length);
		System.out.println("arr2 배열길이 : " + arr2.length);
		System.out.println("arr3 배열길이 : " + arr3.length);
		
		// 배열 반복문
		
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i] + " ");
		}
		
		System.out.println();
		
		for(char ch : arr2) {
			// 반복문(변수선언 배열반복변수 : 변수에 넣을 배열)
			System.out.print(ch+ " ");
		}

		System.out.println();
		
		for(String str : arr3) {

			System.out.print(str+ " ");
		}
		System.out.println();
		// 1차원 배열
		
		int[] scores = {80,60,78,62,92};
		int total = 0;
		
		for(int score : scores) {
			total += score;
		}
		System.out.println("scores 배열의 총합 : " + total);
		
		// 2차원 배열
		int[][] arr2d = {{1,  2,  3,  4},
						 {5,  6,  7,  8},
						 {9, 10, 11, 12}};
		
		for(int a=0 ; a<3 ; a++) {
			for(int b=0 ; b<4;b++) {
				System.out.println("arr2d["+a+"]["+b+"] : "+arr2d[a][b]);
			}
		}
		
		
		// 3차원 배열
		
		int[][][] arr3d = {{{ 1, 2, 3},
							{ 4, 5, 6},
							{ 7, 8, 9}},
						   {{10,11,12},
							{13,14,15},
							{16,17,18}},
						   {{19,20,21},
							{22,23,24},
							{25,26,27}}};
		for(int a=0;a<3;a++) {
			for(int b=0;b<3;b++) {
				for(int c=0;c<3;c++) {
					System.out.printf("arr3d[%d][%d][%d] : %d\n",a,b,c,arr3d[a][b][c]);
				}
			}
		}
	}
}
