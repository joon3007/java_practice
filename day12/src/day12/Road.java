package day12;

import javax.swing.JOptionPane;

class Car {
	// �귣��, ����, ����
	// �õ� �Ѳ���
	// �⺻������
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
		return Integer.parseInt(JOptionPane.showInputDialog("�õ� ��й�ȣ�Է�"));
	}

	void engineStart(int password) {
		if (checkPassword(password)) {
			System.out.println("Ŵ");
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
		JOptionPane.showMessageDialog(null, "���� �⵿ ��");
	}

	void engineStop() {
		System.out.println("��");
	}
}

public class Road {
	public static void main(String[] args) {
		Car car = new Car("����", 3000, "����", 1234);
		car.engineStart(car.inputPassword());
	}

}
