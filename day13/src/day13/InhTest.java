package day13;

class Car {
	String brand;
	String color;
	int price;

	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String brand, String color, int price) {
		// �ֻ�� �θ� Ŭ������ ������ ȣ��
		super();
		this.brand = brand;
		this.color = color;
		this.price = price;
	}

	void engineStart() {
		System.out.println(this.brand + "�õ� Ŵ");
	}

	void engineStop() {
		System.out.println(this.brand + "�õ� ��");
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
		System.out.printf("�������� ");
		// super�� �θ�Ŭ���� ������ ����.
		// super.engineStart() -> Car(�θ�).engineStart()
		super.engineStart();
	}

	@Override
	void engineStop() {
		// TODO Auto-generated method stub
		System.out.printf("�������� ");
		super.engineStop();
	}

	void openRoof() {
		System.out.println(this.brand + " ���ؿ���");
	}

	void closeRoof() {
		System.out.println(this.brand + " ���شݱ�");
	}
}

public class InhTest {
	public static void main(String[] args) {
		
	}
}
