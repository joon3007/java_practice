package day03;

import java.util.Scanner;

public class InputForString {
	public static void main(String[] args) {
		String name = "";
		String age = "";
//		String firstName = "";
//		String lastName = "";
		String nameMsg = "�̸� : ";
		String ageMsg = "���� : ";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.printf(nameMsg);		
		name = sc.nextLine()+"��";
		//���� ���
		sc.nextLine();
		System.out.printf(ageMsg);
		age = sc.nextLine()+"��";
//		lastName = sc.next();
//		firstName = sc.next() + "��";
//		name = lastName + firstName;
		System.out.println(name);
		System.out.println(age);
		
	}
}
