package inter;

public class Private implements Soldier {

	@Override
	public void eat() {
		System.out.println("�㸮�� ��� ��� �Ļ縦 �Ѵ�.");
	}

	@Override
	public void sleep() {
		System.out.println("���� ������ ��𰣴�.");
	}

	@Override
	public void work() {
		System.out.println("������ ������ ����� ���� ������ ��𰣴�.");
	}

	@Override
	public void salute() {
		System.out.println("��!!!!!!!!!!!!!!!!!!!!!��!!!!!!!!!!!!!!!!!!!");
	}

}
