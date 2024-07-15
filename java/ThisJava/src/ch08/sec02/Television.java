package ch08.sec02;

public class Television implements RemoteControl {

	@Override
	public void turnOn() {		// 인터페이스에 선언된 turnOn() 추상 메소드 재정의
		System.out.println("TV를 켭니다.");
		
	}

}
