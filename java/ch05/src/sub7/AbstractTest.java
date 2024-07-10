package sub7;
/*
 * 날짜 : 2024/07/10
 * 이름 : 김주경
 * 내용 : 추상 클래스 실습
 */
public class AbstractTest {

	public static void main(String[] args) {
		
//		Animal animal = new Animal(); 	// 추상 클래스는 객체생성X
		Animal tiger = new Tiger();
		Animal eagle = new Eagle();
		Animal shark = new Shark();
		
		tiger.move();
		tiger.hunt();
		
		eagle.move();
		eagle.hunt();
		
		shark.move();
		shark.hunt();
	}
}
