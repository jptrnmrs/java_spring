package sub7;

// 추상 클래스 - 추상 메서드를 갖는 메서드 , 상속을 위한 클래스, 실제 구현X (new Animal 불가)
public abstract class Animal {
	
	public void move() {
		System.out.println("Animal move...");
	}
	// 추상 메서드 - 내용이 없는 메서드, 오버라이드를 위한 메서드
	public abstract void hunt();
}
