package day13;

class Car {
	String brand;
	String color;
	int price;

	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String brand, String color, int price) {
		// 최삳뒤 부모 클래스의 생성자 호출
		super();
		this.brand = brand;
		this.color = color;
		this.price = price;
	}

	void engineStart() {
		System.out.println(this.brand + "시동 킴");
	}

	void engineStop() {
		System.out.println(this.brand + "시동 끔");
	}
}

class SuperCar extends Car {
	String mode;

	public SuperCar() {
		// TODO Auto-generated constructor stub
	}

	public SuperCar(String brand, String color, int price, String mode) {
		super(brand, color, price);
		this.mode = mode;
	}

	@Override
	void engineStart() {
		// TODO Auto-generated method stub
		System.out.printf("음성으로 ");
		// super는 부모클래스 명으로 본다.
		// super.engineStart() -> Car(부모).engineStart()
		super.engineStart();
	}

	@Override
	void engineStop() {
		// TODO Auto-generated method stub
		System.out.printf("음성으로 ");
		super.engineStop();
	}

	void openRoof() {
		System.out.println(this.brand + " 지붕열기");
	}

	void closeRoof() {
		System.out.println(this.brand + " 지붕닫기");
	}
}

public class InhTest {
	public static void main(String[] args) {
		
	}
}
