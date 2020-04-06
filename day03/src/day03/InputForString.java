package day03;

import java.util.Scanner;

public class InputForString {
	public static void main(String[] args) {
		String name = "";
		String age = "";
//		String firstName = "";
//		String lastName = "";
		String nameMsg = "¿Ã∏ß : ";
		String ageMsg = "≥™¿Ã : ";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.printf(nameMsg);		
		name = sc.nextLine()+"¥‘";
		//∂Û¿Œ ªÛº‚
		sc.nextLine();
		System.out.printf(ageMsg);
		age = sc.nextLine()+"ªÏ";
//		lastName = sc.next();
//		firstName = sc.next() + "¥‘";
//		name = lastName + firstName;
		System.out.println(name);
		System.out.println(age);
		
	}
}
