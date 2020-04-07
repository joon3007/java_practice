package bank;

public class Bank {
	// 3���� ����, �� ���ະ �ִ� �� �� 100(2���� �迭)
	static Bank[][] bank = new Bank[3][100];
	// �� ���ະ ������ ������ �� �ִ� �迭
	static int[] client = new int[bank.length];

	int bank_id;
	// key��
	private int key = 10;
	// ������
	String name;
	// ���¹�ȣ
	String accountNum;
	// �ڵ�����ȣ
	String phoneNum;
	// ��й�ȣ
	String password;
	// �ܰ�
	int money;

	public Bank() {
	}

	public Bank(String name, String accountNum, String phoneNum, String password, int money) {
		super();
		this.name = name;
		this.accountNum = accountNum;
		this.phoneNum = phoneNum;
		this.password = password;
		this.money = money;
	}

	Bank checkDupAccount(String account) {
		for (int i = 0; i < bank.length; i++) {
			for (int j = 0; j < bank[i].length; j++) {
				if (bank[i][j].accountNum.equals(account))
					return bank[i][j];
			}
		}
		return null;
	}

	Bank searchAccount(String account) {
		Bank temp = checkDupAccount(account);
		if (temp != null)
			return temp;
		else
			return null;
	}
	// �ߺ��˻�
	// ���¹�ȣ�� �޾ƿͼ� ����ҿ��� �˻����ִ� �޼ҵ�
	// �ߺ����� �ƴ��� �Ǵ�.

	// �ڵ��� ��ȣ �ߺ��˻�
	// ���� �ߺ��˻�� ���������� �ڵ��� ��ȣ�� ���޹޾Ƽ�
	// �ߺ����� �ƴ��� �Ǵ�.
	Bank checkDupPassword(String phoneNum) {
		for (int i = 0; i < bank.length; i++) {
			for (int j = 0; j < bank[i].length; j++) {
				if (bank[i][j].phoneNum.equals(phoneNum))
					return bank[i][j];
			}
		}
		return null;
	}

	Bank searchPhoneNum(String phoneNum) {
		Bank temp = checkDupPassword(phoneNum);
		if (temp != null)
			return temp;
		else
			return null;
	}

	// �α���
	// �ֺο��� ���¹�ȣ�� ��й�ȣ ���޹ޱ�
	// �α��� ����, ���� �Ǵ��ϱ�
	void login(String accountNum, String password) {
		String temp = encryptPassword(password);
		String msg = "";
		if (searchAccount(accountNum) != null) {
			if (searchAccount(accountNum).password.equals(temp)) {
				msg = "�α��� ����";
			} else {
				msg = "�α��� ����";
			}
		} else
			msg = "�α��� ����";
		System.out.println(msg);
	}

	// ��ȣȭ
	// �ܺο��� �����ȣ ���޹ް� �ƽ�Ű�ڵ�� ��ȣȭ �� ����
	// ��ȣȭ
	// �ܺο��� ��ȣȭ�� ��й�ȣ�� ���޹ް� ��ȣȭ �� ����

	public void setPassword(String password) {
		String temp = encrypt(password);
		this.password = temp;
	}

	private String encryptPassword(String password) {
		String temp = encrypt(password);
		return temp;
	}

	private String encrypt(String password) {
		String temp = "";
		for (int i = 0; i < password.length(); i++) {
			temp += (char) (password.charAt(i) * key);
		}
		return temp;
	}

	void deposit(int money) {
		this.money += money;
	}

	boolean withdraw(int money) {
		boolean check = false;
		if (this.money - money > 0) {
			check = true;
			this.money -= money;
		}
		return check;
	}

	@Override
	public String toString() {
		String msg = "���¹�ȣ : " + this.accountNum + 
				"\n������ : " + this.name + 
				"\n���� �ܾ� : " + this.money + "��";
		return msg;
	}
	
	static Bank getInstance(int bank_num) {
		if( bank_num == 1 )
			return new Shinhan();
		else if( bank_num == 2)
			return new Kookmin();
		else if( bank_num == 3)
			return new Woori();
		return null;
	}
}
