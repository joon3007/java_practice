package bank;

public class Shinhan extends Bank {
	//입금시 수수료 50%
	@Override
	void deposit(int money) {
		money *= 0.5;
		super.deposit(money);
	}
}
