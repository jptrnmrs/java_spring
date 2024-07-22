package sub2;

/*
 * 날짜 : 2024. 7. 22.
 * 이름 : 김주경
 * 내용 : 스레드 상태 실습
 */
class SubThread extends Thread{
	@Override
	public void run() {	// 작업 스레드로 처리할 메서드
		int i = 1;

		try {
			for(;;) {
				System.out.println("Sub Thread 실행..."+i);
				Thread.sleep(1000);	// 스레드 1초 대기
				i++;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		System.out.println("Sub Thread 종료..."); -- 위쪽이 무한반복이라 닿지 않음
	}
}

public class ThreadInterruptTest {
	public static void main(String[] args) {
		SubThread sub = new SubThread();
		sub.start();
		try {
			Thread.sleep(1000*10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sub.interrupt(); // 작업 스레드 종료
		System.out.println("Main 스레드 종료");
	}
}
