package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ArListTest {
	public static void main(String[] args) {
		ArrayList<Integer> dataList = new ArrayList<>();
		dataList.add(30);
		dataList.add(60);
		dataList.add(50);
		dataList.add(20);
		dataList.add(40);
		dataList.add(10);
		dataList.add(70);
		dataList.add(90);

//		for(int data : dataList) {
//			System.out.println(data);
//		}
		try {
			// 90�� 900���� ����
			dataList.set(dataList.indexOf(90), 900);
			// 30�� ����
			dataList.remove((Object) 20);
			dataList.remove((Integer) 70);
			dataList.remove(new Integer(60));
			dataList.remove(dataList.indexOf(30));

			//����
			System.out.println(dataList);
			Collections.shuffle(dataList);
			System.out.println(dataList);
			
			//����
			System.out.println(dataList);
			Collections.sort(dataList);
			System.out.println(dataList);

			//�¿����
			System.out.println(dataList);
			Collections.reverse(dataList);
			System.out.println(dataList);
			
			// 50 �ڿ��ִ� ���� ���
			System.out.println(dataList.get((dataList.indexOf(50) + 1)));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�����Ͱ� �����ϴ�.");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("���� �����Ͱ� �����ϴ�.");
		}

	}
}
