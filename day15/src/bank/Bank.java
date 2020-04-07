package bank;

public class Bank {
	//��� ��ü�� �����ؾ��ϴ� ������̹Ƿ� static�� �ٿ��ش�.
	
	//3���� ����, �� ���ະ �ִ� �� �� 100(2���� �迭)
	static Bank[][] arBank = new Bank[3][100];
	//�� ���ະ ������ ������ �� �ִ� �迭(1���� �迭)
	static int[] arCnt = new int[arBank.length];
	
	//KEY ��
	private final int KEY = 3;
	//������
	String name;
	//���¹�ȣ
	String account;
	//�ڵ���	��ȣ
	String phone;
	//��й�ȣ
	String pw;
	//�ܰ�
	int money;
	//���� �����ȣ
	int bank_num;
	
	//*���¹�ȣ �ߺ��˻�
	//���¹�ȣ�� �޾ƿͼ� ����ҿ��� �˻����ִ� �޼ҵ�
	//�ߺ����� �ƴ��� �Ǵ�
	Bank checkDup_account(String account) {
		Bank b = null;
		//���� ������ŭ �ݺ�
		for (int i = 0; i < arBank.length; i++) {
			//���ະ ��ϵ� ȸ�� �� ��ŭ �ݺ�
			for (int j = 0; j < arCnt[i]; j++) {
				//���Ե� ��� ���� ���¹�ȣ�� ���޹��� ���¹�ȣ ��
				if(arBank[i][j].account.equals(account)) {
					//b�� ã�� ��ü ����
					b = arBank[i][j];
					//�� ��ü�� ���� ��ȣ�� ���ȣ ����
					//(���� �����ȣ ���� 0:����,1:����,2:�츮)
					b.bank_num = i;
//					System.out.println(bank_num);
					break;
				}
			}
		}
		//���¹�ȣ�� ���ٸ� null, �ִٸ� ã�� ��ü ����
		return b;
	}
	
	//*�ڵ��� ��ȣ �ߺ��˻�
	//���� �ߺ��˻�� ���������� �ڵ��� ��ȣ�� ���޹޾Ƽ�
	//�ߺ����� �ƴ��� �Ǵ�
	Bank checkDup_phone(String phone) {
		Bank b = null;
		for (int i = 0; i < arBank.length; i++) {
			for (int j = 0; j < arCnt[i]; j++) {
				if(arBank[i][j].phone.equals(phone)) {
					b = arBank[i][j];
					break;
				}
			}
		}
		return b;
	}
	
	//*�α���
	//�ܺο��� ���¹�ȣ�� ��й�ȣ ���޹ޱ�
	//�α��� ����, ���� �Ǵ��ϱ�
	Bank login(String account, String pw) {
		//���¹�ȣ�� �ִٸ� �� ��ü�� b�� ����
		//������ null�� ����.
		Bank b = checkDup_account(account);
		if(b != null) {
			//���¹�ȣ�� �ִٸ� ������ ����
			if(!decrypt(b.pw).equals(pw)) {
				//��й�ȣ ������ ������ ����
				b = null;
			}
		}
		//�α��� ���� : null ����
		//�α��� ���� : �ش� ��ü ����
		return b;
	}
	//*��ȣȭ
	//�ܺο��� ��й�ȣ ���޹ް� �ƽ�Ű�ڵ�� ��ȣȭ �� ����
	String encrypt(String pw) {
		String result = "";
		for (int i = 0; i < pw.length(); i++) {
			//���޹��� pw���ڿ��� �� ���ڿ� KEY���� �����ش�.
			//�� �� result�� �ٽ� �����������ش�.
			//��� ���ڰ� ��ȣȭ �ȴ�.
			result += (char)(pw.charAt(i) * KEY);
		}
		//��ȣȭ�� ��й�ȣ ����
		return result;
	}
	//*��ȣȭ
	//�ܺο��� ��ȣȭ�� ��й�ȣ ���޹ް� ��ȣȭ �� ����
	String decrypt(String en_pw) {
		String result = "";
		for (int i = 0; i < en_pw.length(); i++) {
			result += (char)(en_pw.charAt(i) / KEY);
		}
		return result;
	}
	//���Ա�
	//�Աݱݾ� ���޹ް� ��ü ���忡 �� �ֱ�
	void deposit(int money) {
		this.money += money;
	}
	
	//�����
	//��ݱݾ� ���޹ް� ��ü ���忡 �� �ֱ�
	//��, �ܾ� ���� �˻� �ʼ�!
	boolean withdraw(int money) {
		boolean check = false;
		
		if(money - this.money <= 0) {
			this.money -= money;
			check = true;
		}
		//�ܾ׺����� false, �ƴϸ� true
		return check;
	}
	
	//�ܾ���ȸ
	@Override
	public String toString() {
		//Object(�ֻ��� Ŭ����)�� �ִ� toString()�� ��ü�� ����� �� 
		//�׻� �����Ǿ� ���ȴ�.
		//��ü��.toString() == ��ü��
		//���� �ּҰ� �ƴ� ���ϴ� ���� �ٷ�� ���� ������
		//toString()�� ���������ش�.
		String msg = "���¹�ȣ : " + this.account +
				"\n������ : " + this.name +
				"\n���� �ܾ� : " + this.money + "��";
		return msg;
	}
	
	static Bank getInstance(int bank_num) {
		//����ڰ� ������ ���࿡ �´� ���ο� ��ü�� �������ش�. 
		if(bank_num == 1) {
			return new Shinhan();
		}else if(bank_num == 2) {
			return new Kookmin();
		}else if(bank_num == 3) {
			return new Woori();
		}
		return null;
	}
}





