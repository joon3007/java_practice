package day14;

class Car {
	String brand;
	String color;
	int price;

	public Car() {
		// �ڽ��� �׻� �θ��� �⺻�����ڸ� ȣ���Ѵ�.
		// ���� �⺻�����ڰ� ���ٸ� ��ӽ� ������ ����.
		// �ֳ��ϸ� �θ��� �⺻ �����ڰ� ���� �����̴�.
		// ���� Ŭ���� ����� �⺻ �����ڸ� �������ִ� ������ �ʿ��ϴ�.
	}

	public Car(String brand, String color, int price) {
		super();
		this.brand = brand;
		this.color = color;
		this.price = price;
	}

	void engineStart() {
		System.out.println("�õ� Ŵ");
	}

	void engineStop() {
		System.out.println("�õ� ��");
	}
}

class SuperCar extends Car {

	String mode;

	public SuperCar() {
	}

	public SuperCar(String brand, String color, int price, String mode) {
		super(brand, color, price);
		this.mode = mode;
	}

	@Override
	void engineStart() {
		System.out.printf("�������� ");
		super.engineStart();
	}
	
	@Override
	void engineStop() {
		System.out.printf("�������� ");
		super.engineStop();
	}
	void openRoof() {
		System.out.println("���� "
				+ "����");
	}

	void closeRoof() {
		System.out.println("���� �ݱ�");
	}

}

public class Road {
	public static void main(String[] args) {
		//up casting
		Car noOpCar = new SuperCar("Ferrari", "red", 5000, "Sport");
		noOpCar.engineStart();
		
		//down casting
//		SuperCar test = (SuperCar)new Car(); �߸��� ���
		SuperCar OpCar = (SuperCar) noOpCar;
		OpCar.openRoof();
	}
}
