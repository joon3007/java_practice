package day03;

import java.util.Scanner;

public class InputTest {
	public static void main(String[] args) {
		String name = "";
		//���� ����� ���� ������ ���� ���� ������
		//�ʱⰪ�� �־������ν� �ʱ�ȭ�� ���ش�.
		//���� : 0
		//�Ǽ� : 0.0
		//����: ''
		//���ڿ�: "", null
		
		Scanner sc = new Scanner(System.in);
		//Ŭ���� �ȿ� �ִ� �޼ҵ带 ����ϰ��� �Ҷ�����
		//Ŭ���� Ÿ���� ������ ���� �� ������ ��ħǥ�� �� �����Ѵ�.
		System.out.print("�̸� : ");
		name = sc.next();
		System.out.println(name+"��");
		//ctrl + �޼ҽ� Ȥ�� ���� Ŭ�� : ����� �κ����� �̵�
		//�⺻ ���� ���̺귯�� �޼ҵ带 Ŭ���ϰ� �Ǹ�
		//����۰� �ڵ带 �� �� ������, ó�� ������ ������
		//��ġ�� �˷��־�� �Ѵ�.
		//attach source Ŭ�� > external üũ > jdk���� �ȿ� src.zip ����Ŭ�� 
		sc.close();
		//�ѹ� ������ ���� �ٽ� �� �� ����.
		
	}
}
