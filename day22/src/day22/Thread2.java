package day22;

public class Thread2 implements Runnable{
	String data;
	
	public Thread2() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Thread2(String data) {
		super();
		this.data = data;
	}


	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println(data);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
