package day22;
import java.lang.Thread;

public class Thread1 extends Thread {
	String data;

	public Thread1() {
	}

	public Thread1(String data) {
		super();
		this.data = data;
	}

	@Override
	public void run() {
		// 쓰레드 구현
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(this.data);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
