package bank;

public class Shinhan extends Bank {
	//�Աݽ� ������ 50%
	@Override
	void deposit(int money) {
		money *= 0.5;
		super.deposit(money);
	}
}
