package ch08.sec02;

public class RemoteControlExample {
	
	public static void main(String[] args) {
		
		RemoteControl rc;
		
		//rc 변수에 Televsion 객체를 대입
		rc = new Television();
		rc.turnOn();
		
		//rc 변수에 Audio 객체를 대입(교체시킴)
		rc = new Audio();
		rc.turnOn();
	}
}
