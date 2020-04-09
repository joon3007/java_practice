package vo;

public class UserVO {
	private static int seq;
	private int num;
	private String name;
	private int age;
	
	public UserVO() {
		this.num = ++seq;
	}

	public static int getSeq() {
		return seq;
	}

	public static void setSeq(int seq) {
		UserVO.seq = seq;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		String msg = "��ȣ : "+this.num+"\n�̸�:"+this.name+"\n����"+this.age+"��";
		return msg;
	}
	
}
