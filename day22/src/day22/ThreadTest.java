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
		
		//�� �ɽ���
		Runnable t1 = new Thread2("!");
		Runnable t2 = new Thread2("@");
		
		//Tread �������� �Ķ���Ͱ� Runnable�̱� ������ ���ɽ��õǾ� ����.
		Thread th1 = new Thread(t1);
		Thread th2 = new Thread(t2);
		
		//��Ƽ ������(2���� ������)
		//���޸��� Runnable ��ü�� �ִ� run()�� �����ٸ� ���ش�.
		th1.start();
		th2.start();
		
		//���� ���� �۾��ϱ� ���� join()�� ����Ѵ�.
		th1.join();
		th2.join();
		
		//join()�� ������� ���� main ������� ���� �۾��� ��� �Ϸ�� �� ����ȴ�.
		System.out.println("���θ޼ҵ� ����");
	}
}
