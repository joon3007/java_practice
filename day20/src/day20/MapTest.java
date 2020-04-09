package day20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		HashMap<String, Integer> fruitMap = new HashMap<>();
		ArrayList<Integer> prices = new ArrayList<>();
		
		fruitMap.put("���", 1500);
		fruitMap.put("��", 2000);
		fruitMap.put("�ڵ�", 500);
		fruitMap.put("����", 8000);
		
		System.out.println(fruitMap);
		fruitMap.put("�ڵ�", 1000);
		System.out.println(fruitMap.get("�ڵ�"));
		System.out.println(fruitMap.containsKey("�ڵ�"));
		
		Set<String> set = fruitMap.keySet();
		Iterator<String> iter = set.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
//		for(int data : fruitMap.values()) {
//			System.out.println(data + "��");
//		}
		
		//CollectionŸ�Կ����� forEach()�޼ҵ带 �������ش�.
		//forEach(������ -> ������ ����);
		//������ ���忡�� ȭ��ǥ �ڿ� �ִ� ������ ����� �� �ִ�.
		//���� �� �̻� ���� ������ �ݺ��Ѵ�.
		fruitMap.values().forEach(price -> prices.add(price));
		System.out.println(prices);
		
		//Key, Value �� ���� �ʿ��� ������ keySet(), values() 2���� ������� �ʰ�
		//entrySet()�� ����Ͽ� �� ���� �� ������ �� �� �ִ�.
		Iterator<Entry<String, Integer>> iter_entry = fruitMap.entrySet().iterator();
		
		while(iter_entry.hasNext()) {
			//�ȿ� �ִ� ��ü�� Entry<String, Integer>Ÿ���̹Ƿ�
			//�ش� ��ü�� �־��ְ� ����Ѵ�.
			Entry<String, Integer> entry = iter_entry.next();
			System.out.println(entry.getKey() + "-" + entry.getValue() + "��");
		}
	}
}






