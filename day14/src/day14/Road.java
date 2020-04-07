package day14;

class Car {
	String brand;
	String color;
	int price;

	public Car() {
		// 자식은 항상 부모의 기본생성자를 호출한다.
		// 만약 기본생성자가 없다면 상속시 오류가 난다.
		// 왜냐하면 부모의 기본 생성자가 없기 때문이다.
		// 따라서 클래스 선언시 기본 생성자를 선언해주는 습관이 필요하다.
	}

	public Car(String brand, String color, int price) {
		super();
		this.brand = brand;
		this.color = color;
		this.price = price;
	}

	void engineStart() {
		System.out.println("시동 킴");
	}

	void engineStop() {
		System.out.println("시동 끔");
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
		System.out.printf("음성으로 ");
		super.engineStart();
	}
	
	@Override
	void engineStop() {
		System.out.printf("음성으로 ");
		super.engineStop();
	}
	void openRoof() {
		System.out.println("지붕 "
				+ "열기");
	}

	void closeRoof() {
		System.out.println("지붕 닫기");
	}

}

public class Road {
	public static void main(String[] args) {
		//up casting
		Car noOpCar = new SuperCar("Ferrari", "red", 5000, "Sport");
		noOpCar.engineStart();
		
		//down casting
//		SuperCar test = (SuperCar)new Car(); 잘못된 사용
		SuperCar OpCar = (SuperCar) noOpCar;
		OpCar.openRoof();
	}
}
