package inter;

public class Corporal implements Soldier {

	@Override
	public void eat() {
		System.out.println("��ġ�� ���� �Ļ��Ѵ�.");
	}

	@Override
	public void sleep() {
		System.out.println("�� �ܴ�.");
	}

	@Override
	public void work() {
		System.out.println("���� ��Ų��.");
	}

	@Override
	public void salute() {
		System.out.println("����");
	}

}
