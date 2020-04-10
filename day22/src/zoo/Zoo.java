package zoo;

public class Zoo {
	public static void main(String[] args) throws InterruptedException {
		//���� 3������ ���������� �����Ҹ��� ����.
		//�θ��� ������ ���ÿ� 10�� ���
		//���� ������ �������� 10�� ���.
		//��Ƽ ������� �����Ѵ�(Runnable ���)
		
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
