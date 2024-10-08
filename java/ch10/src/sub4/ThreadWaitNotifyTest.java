package sub4;

/*
 * 날짜 : 2024. 7. 22.
 * 이름 : 김주경
 * 내용 : 스레드 제어 실습 교재 p617-619
 */
class WorkObject {
	public synchronized void methodA() {
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + " : methodA 작업 실행");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}
	public synchronized void methodB() {
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + " : methodB 작업 실행");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}
}

class ThreadA extends Thread{
		private WorkObject workObject;

		public ThreadA(WorkObject workObject) {
			setName("ThreadA");
			this.workObject = workObject;
		}
		@Override
		public void run() {
			for(int i=0; i<10;i++) {
				workObject.methodA();
			}
		}
		
	}
 
class ThreadB extends Thread{
	private WorkObject workObject;

	public ThreadB(WorkObject workObject) {
		setName("ThreadB");
		this.workObject = workObject;
	}
	@Override
	public void run() {
		for(int i=0; i<10;i++) {
			workObject.methodB();
		}
	}
}

public class ThreadWaitNotifyTest {
	public static void main(String[] args) {
		WorkObject workObject = new WorkObject();
		
		ThreadA threadA = new ThreadA(workObject);
		ThreadB threadB = new ThreadB(workObject);
		
		threadA.start();
		threadB.start();
	}
}
