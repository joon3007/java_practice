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
			// 90을 900으로 수정
			dataList.set(dataList.indexOf(90), 900);
			// 30을 삭제
			dataList.remove((Object) 20);
			dataList.remove((Integer) 70);
			dataList.remove(new Integer(60));
			dataList.remove(dataList.indexOf(30));

			//셔플
			System.out.println(dataList);
			Collections.shuffle(dataList);
			System.out.println(dataList);
			
			//정렬
			System.out.println(dataList);
			Collections.sort(dataList);
			System.out.println(dataList);

			//좌우반전
			System.out.println(dataList);
			Collections.reverse(dataList);
			System.out.println(dataList);
			
			// 50 뒤에있는 정수 출력
			System.out.println(dataList.get((dataList.indexOf(50) + 1)));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("데이터가 없습니다.");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("다음 데이터가 없습니다.");
		}

	}
}
