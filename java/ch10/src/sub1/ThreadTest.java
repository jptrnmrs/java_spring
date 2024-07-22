package sub1;

/*
 * 날짜 : 2024. 7. 22.
 * 이름 : 김주경
 * 내용 : 스레드 실습
 */
public class ThreadTest {
	public static void main(String[] args) {
		SubThread sub1 = new SubThread("sub1");
		SubThread sub2 = new SubThread("sub2");
	
		sub1.start();
		sub2.start();
		
		for(int i=0; i<10; i++) {
			System.out.println("main Thread 실행...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
		System.out.println("main Thread 종료...");
	}
}
