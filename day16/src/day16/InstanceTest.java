package day16;

//���߱���
class Transportaion {
}

class Bus extends Transportaion {
}

public class InstanceTest {
	public static void main(String[] args) {
//		System.out.println(new Integer(10) instanceof Integer);
//		System.out.println("�ȳ�" instanceof String);
//		System.out.println(new Float(3.156F) instanceof Float);
//		
//		Object[] a = {1,"�ȳ�",3.14};
		
		Transportaion t = new Transportaion();
		Bus b = new Bus();
		
		Transportaion upcasting = new Bus();
		Bus downcasting = (Bus) upcasting;
		
		//upcasting�� ��ü�� downcasting�ϴ� ����
		//upcasting�Ǹ鼭 �ڽ� Ŭ������ ���Ӱ� �߰��� �ʵ�� ��� �߷��� ����.
		// ���� �ڽ� �ʵ忡�� ���� �߰��� ����� ��� ����ϰ�ʹٸ�
		//downcasting�� �ؾ��Ѵ�.
		//instanceof�� ����ؾ� �ϴ� ����
		//upcasting�� ��ü�� � �ڽİ��� �� �ִ� ���� �˻��� �ʿ䰡 �ִ�.
		//�� �ִ� �ڽ� Ÿ�Կ� �°� downcasting�� �ϱ� ���� ����Ѵ�.
		
		
	}
}
