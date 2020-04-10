package day22;

public class ThreadTest {
	public static void main(String[] args) throws InterruptedException {
//		Thread1 t1 = new Thread1("1");
//		Thread1 t2 = new Thread1("2");
//		
//		t1.start();
//		t2.start();
//		t1.run();
//		t2.run();
		
		//업 케스팅
		Runnable t1 = new Thread2("!");
		Runnable t2 = new Thread2("@");
		
		//Tread 생성자의 파라메터가 Runnable이기 떄문에 업케스팅되어 들어간다.
		Thread th1 = new Thread(t1);
		Thread th2 = new Thread(t2);
		
		//멀티 쓰레드(2개의 쓰레드)
		//전달맏은 Runnable 객체에 있는 run()을 스케줄링 해준다.
		th1.start();
		th2.start();
		
		//가장 먼저 작업하기 위해 join()을 사용한다.
		th1.join();
		th2.join();
		
		//join()을 사용하지 않은 main 쓰레드는 위의 작업이 모두 완료된 후 실행된다.
		System.out.println("메인메소드 종료");
	}
}
