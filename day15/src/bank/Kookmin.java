package bank;

public class Kookmin extends Bank {
	//��ݽ� ������ 50%
	//100������ �̴´�. �׷��� 150������ �ʿ��ϴ�
	//100 ????? 150
	//1.5
	//�ݵ�� super�� ����ϱ�
	@Override
	boolean withdraw(int money) {
		money *= 1.5;
		return super.withdraw(money);
	}
}
