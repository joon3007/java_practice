package collection;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTask {
	public static void main(String[] args) {
		//��ǰ��, ������ �������ִ� ArrayList ����(2����)
		ArrayList<ArrayList> products = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		//1. ��ǰ���
		ArrayList product = new ArrayList<>();
		System.out.print("��ǰ�� : ");
		product.add(sc.next());
		System.out.print("���� : ");
		product.add(sc.nextInt());
		products.add(product);
		for(ArrayList prod : products) {
			System.out.println(prod);
		}
		//2. ��ǰ����
		//3. ��ǰ �˻�
		//4. ��ǰ ����
		//5.��ǰ ���
		//6. ������
	}
}
