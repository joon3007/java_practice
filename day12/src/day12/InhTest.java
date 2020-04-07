package day12;

class A{
	int data;

	public A() {
		System.out.println("부모생성자 호출됨");
	}

	public A(int data) {
		this.data = data;
	}
	
	void intro() {
		System.out.println("안녕하세요");
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
		System.out.println("자식생성자 호출됨");
		this.name = name;
	}
	
	@Override
	void intro() {
		// TODO Auto-generated method stub
		super.intro();
		System.out.println(name+"입니다.");
	}
	
	void printName() {
		
	}
}
public class InhTest {
	public static void main(String[] args) {
		B obj = new B("김휘준");
		obj.printName();
	}
}
