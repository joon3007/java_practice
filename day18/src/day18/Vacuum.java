package day18;

public class Vacuum implements Electronics{

	@Override
	public void on() {
		System.out.println("��ư�� ������ �ѱ�");
	}

	@Override
	public void off() {
		System.out.println("��ư�� ������ ����");
	}

}
