package bank;

public class Woori extends Bank {
	//�ܾ���ȸ�� ��� ���丷
	@Override
	public String toString() {
		this.money *= 0.5;
		return super.toString();
	}
}
