package day11;

class Car2 {
	// 브랜드, 색상, 가격
	// 기본 생성자
	// 초기화 생성자 3개
	// 시동켜기
	// 시동끄기
	String brand;
	int price;
	String color;
	boolean isStart;

	public Car2() {
		// TODO Auto-generated constructor stub
	}

	public Car2(String brand) {
		this.brand = brand;
	}

	public Car2(String brand, int price, String color) {
		this.brand = brand;
		this.price = price;
		this.color = color;
	}

	public Car2(String brand, int price) {
		this.brand = brand;
		this.price = price;
	}

	public void engineStart() {
		// TODO Auto-generated method stub
		System.out.println(isStart ? "이미 시동이 켜져있습니다." : "시동 킴");
		isStart = true;
	}

	public void engineStop() {
		// TODO Auto-generated method stub
		System.out.println(!isStart ? "이미 시동이 꺼져있습니다." : "시동 끔");
		isStart = false;
	}

}

public class Load2 {

	public static void main(String[] args) {
		Car2 car = new Car2("Benz", 9000, "blue");
		Car2 car2 = new Car2("Bentley", 8000);
		Car2 car3 = new Car2("Hyendea");
		car.engineStart();
		car.engineStart();
		car.engineStop();
	}
}
