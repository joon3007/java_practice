package day12;

class A{
	int data;

	public A() {
		System.out.println("�θ������ ȣ���");
	}

	public A(int data) {
		this.data = data;
	}
	
	void intro() {
		System.out.println("�ȳ��ϼ���");
	}
	void printData() {
		System.out.println(data);
	}
	
	
}

class B extends A{
	String name;
	
	public B() {
		// TODO Auto-generated constructor stub
	}
	
	
	public B(int data, String name) {
		super(data);
		this.name = name;
	}


	public B(String name) {
		System.out.println("�ڽĻ����� ȣ���");
		this.name = name;
	}
	
	@Override
	void intro() {
		// TODO Auto-generated method stub
		super.intro();
		System.out.println(name+"�Դϴ�.");
	}
	
	void printName() {
		
	}
}
public class InhTest {
	public static void main(String[] args) {
		B obj = new B("������");
		obj.printName();
	}
}
