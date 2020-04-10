package zoo;

public class Zoo {
	public static void main(String[] args) throws InterruptedException {
		//동물 3마리가 동물원에서 울음소리를 낸다.
		//두마리 동물은 동시에 10번 울고
		//남은 동물은 마지막에 10번 운다.
		//멀티 쓰레드로 구현한다(Runnable 사용)
		
		Animal pig = new Pig();
		Animal tiger = new Tiger();
		Animal duck = new Duck();
		
		Thread t1 = new Thread(pig);
		Thread t2 = new Thread(tiger);
		Thread t3 = new Thread(duck);
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		t3.start();
						
	}
}
