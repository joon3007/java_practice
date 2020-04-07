package day12;

import javax.swing.JOptionPane;

class Car {
	// 브랜드, 가격, 생강
	// 시동 켜끄기
	// 기본생성자
	String brand;
	int price;
	String color;
	int password = 1111;
	int count;

	public Car() {
	}

	public Car(String brand, int price, String color) {
		this.brand = brand;
		this.price = price;
		this.color = color;
	}

	public Car(String brand, int price, String color, int password) {
		this.brand = brand;
		this.price = price;
		this.color = color;
		this.password = password;
	}

	int inputPassword() {
		return Integer.parseInt(JOptionPane.showInputDialog("시동 비밀번호입력"));
	}

	void engineStart(int password) {
		if (checkPassword(password)) {
			System.out.println("킴");
		} else {
			if (count == 3)
				callPolice();
			else
				engineStart(inputPassword());
		}
	}

	private boolean checkPassword(int password) {
		count++;
		if (password == this.password) {
			count = 0;
			return true;
		}else
			return false;
	}

	private void callPolice() {
		JOptionPane.showMessageDialog(null, "경찰 출동 중");
	}

	void engineStop() {
		System.out.println("끔");
	}
}

public class Road {
	public static void main(String[] args) {
		Car car = new Car("벤츠", 3000, "빨강", 1234);
		car.engineStart(car.inputPassword());
	}

}
