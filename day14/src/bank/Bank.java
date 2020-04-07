package bank;

public class Bank {
	// 3개의 은행, 각 은행별 최대 고객 수 100(2차원 배열)
	static Bank[][] bank = new Bank[3][100];
	// 각 은행별 고객수를 저장할 수 있는 배열
	static int[] client = new int[bank.length];

	int bank_id;
	// key값
	private int key = 10;
	// 예금주
	String name;
	// 계좌번호
	String accountNum;
	// 핸드폰번호
	String phoneNum;
	// 비밀번호
	String password;
	// 잔고
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
	// 중복검사
	// 계좌번호를 받아와서 저장소에서 검색해주는 메소드
	// 중복인지 아닌지 판단.

	// 핸드폰 번호 중복검사
	// 위의 중복검사와 동일하지만 핸드폰 번호를 전달받아서
	// 중복인지 아닌지 판단.
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

	// 로그인
	// 왜부에서 계좌번호와 비밀번호 전달받기
	// 로그인 성공, 실패 판단하기
	void login(String accountNum, String password) {
		String temp = encryptPassword(password);
		String msg = "";
		if (searchAccount(accountNum) != null) {
			if (searchAccount(accountNum).password.equals(temp)) {
				msg = "로그인 성공";
			} else {
				msg = "로그인 실패";
			}
		} else
			msg = "로그인 실패";
		System.out.println(msg);
	}

	// 암호화
	// 외부에서 비빌번호 전달받고 아스키코드로 암호화 후 리턴
	// 복호화
	// 외부에서 암호화된 비밀번호를 전달받고 복호화 후 리턴

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
		String msg = "계좌번호 : " + this.accountNum + 
				"\n예금주 : " + this.name + 
				"\n현재 잔액 : " + this.money + "원";
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
