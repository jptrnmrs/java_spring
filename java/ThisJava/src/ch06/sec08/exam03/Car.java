package ch06.sec08.exam03;

public class Car {
	// 필드 선언
	int gas;
	
	// 리턴값이 없는 메서드로 매개값을 받아서 gas 매개값을 변경
	void setGas(int gas) {
		this.gas = gas;
	}
	
	// 리턴값이 boolean 인 메서드로 gas 필드값이 0이면 false 를 , 0이 아니면 true 를 리턴
	boolean isLeftGas() {
		if (gas == 0) {
			System.out.println("gas가 없습니다.");
			return false;	// false 를 리턴하고 메서드 종료
		}else {
			System.out.println("gas가 있습니다.");
			return true;	// true 를 리턴하고 메서드 종료
		}
	}
	
	// 리턴값이 없는 메소드로 gas 필드값이 0이면 return 문으로 메서드를 종료
	void run() {
		while(true) {
			if (gas>0) {
				System.out.println("달립니다. (gas잔량 : " + gas + ")");
				gas -= 1;
			} else {
				System.out.println("멈춥니다. (gas잔량 : " + gas + ")");
				return; // 메서드 종료
			}
			
		}
	}
}
