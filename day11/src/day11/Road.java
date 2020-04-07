package day11;

class Car{
	String brand;
	int price;
	String color;

	
	public Car(String brand, int price, String color) {
		this.brand = brand;
		this.price = price;
		this.color = color;
	}

	
	void engineStart() {
		System.out.println(brand+" ½Ãµ¿ Å´");
	}
	
	void engineStop() {
		System.out.println(brand+" ½Ãµ¿ ²û");
	}

	public void showInfo() {
		// TODO Auto-generated method stub
		System.out.println("Â÷·®Á¤º¸");
		System.out.println(this.brand);
		System.out.println(this.price);
		System.out.println(this.color);
	}
}

public class Road {
	public static void main(String[] args) {
		Car mom_car = new Car("Benz",123,"red");
		Car dady_car = new Car("BMW",333,"blue");
		Car my_car = new Car("Bentley",333,"orange");
		System.out.println(mom_car);
		mom_car.engineStart();
		mom_car.showInfo();
		
	}
}
