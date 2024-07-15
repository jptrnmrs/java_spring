package ch04.sec02;
/*
 * 장제목 : 4장 if문
 * 이름 : 최형욱
 * 작성일 : 2024.01.02
 */
public class IfNestedExample {

	public static void main(String[] args) {
		int score = (int)(Math.random()*20) + 81;
		System.out.println("점수: " + score);
		
		String grade;
		
		if(score>=90) {
			if(score>=95) {
				grade = "A+";
			} else {
				grade = "A";
			}
		}
		else {
			if(score>=85) {
				grade = "B+";
			} else {
				grade ="B";
			}
		}
		System.out.println("학점: " + grade);
	}

}
