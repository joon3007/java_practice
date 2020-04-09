package day20;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
	public static void main(String[] args) {
		HashSet<String> blood_types = new HashSet<>();
		
		blood_types.add("A");
		blood_types.add("AB");
		blood_types.add("B");
		blood_types.add("O");
		blood_types.add("O");
		blood_types.add("O");
		blood_types.add("O");
		blood_types.add("O");
		blood_types.add("O");
		blood_types.add("O");
		
		System.out.println(blood_types);
		blood_types.remove("O");
		System.out.println(blood_types.contains("O"));

		//SetŸ�Կ� �ִ� ���鿡 ������ �ο����ִ� iterator()��� �޼ҵ尡 �ִ�.
		//���� Ÿ���� Iterator<>Ÿ���̴�.
		Iterator<String> iter = blood_types.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}





