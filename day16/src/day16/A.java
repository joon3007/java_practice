package day16;

public abstract class A {
	public int data;
	abstract void init(int data);
	abstract void function();
	final void function2() {}; //재정의 불가능 하므로 구현 해야됨
	void aa() {}
}
